package com.Facturacion.service;

import com.Facturacion.dao.RolDao;
import com.Facturacion.dao.UsuarioDao;
import com.Facturacion.domain.Rol;
import com.Facturacion.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDao UsuarioDao;
    @Autowired
    private RolDao rolDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario us = UsuarioDao.findByUsername(username);
        Rol rol = rolDao.findById(us.getIdRol()).orElse(null);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        if (rol.getNombre().equals("ROLE_ADMIN")) {
            roles.add(new SimpleGrantedAuthority("ROLE_VENDEDOR"));
        }
        UserDetails userDet = new User(us.getUsername(), "{noop}" + us.getPassword(), roles);
        return userDet;
    }
}
