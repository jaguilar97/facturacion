package com.Facturacion;

import com.Facturacion.service.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UsuarioDetailsServiceImpl userDetailsService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/producto/eliminar/**", "/categoria/eliminar/**",
                        "/cliente/eliminar/**", "/fencabezado/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/producto/nuevo", "/producto/guardar",
                        "/producto/modificar/**",
                        "/categoria/nuevo", "/categoria/guardar",
                        "/categoria/modificar/**",
                        "/cliente/nuevo", "/cliente/guardar",
                        "/cliente/modificar/**",
                        "/fencabezado/nuevo", "/fencabezado/guardar/",
                        "/fencabezado/modificar/**",
                        "/producto/listado", "/cliente/listado",
                        "/categoria/listado", "/notaCredito/listado", "/")
                .hasAnyRole("ADMIN", "VENDEDOR")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
