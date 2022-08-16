package com.Facturacion.controller;

import com.Facturacion.domain.Fdetalle;
import com.Facturacion.domain.Fencabezado;
import com.Facturacion.domain.Producto;
import com.Facturacion.service.FdetalleService;
import com.Facturacion.service.ProductoService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FdetalleController {

    @Autowired
    private FdetalleService fdetalleService;

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/fdetalle/agregar")
    public String agregar(Producto producto, Fencabezado fencabezado) {
        Long idFactura = fencabezado.getIdFactura();
        producto = productoService.getProducto(producto);
        
        Fdetalle fdetalle = fdetalleService.getFdetalle(idFactura, producto);
        if(fdetalle != null) {
            fdetalle.setCantidad(fdetalle.getCantidad() + 1);
        } else {
            fdetalle = new Fdetalle(idFactura, producto, producto.getPrecio(), 1);
        }
        fdetalleService.save(fdetalle);
        return "redirect:/fencabezado/listado";
    }

    @GetMapping("/fdetalle/listado")
    public String inicio(Model model) {

        var fdetalles = fdetalleService.getFdetalles();
        model.addAttribute("fdetalles", fdetalles);

        return "/fdetalle/listado";
    }

    @GetMapping("/fdetalle/nuevo")
    public String nuevoFdetalle(Fdetalle fdetalle) {
        return "/fdetalle/modificar";
    }

    @PostMapping("/fdetalle/guardar")
    public String guardarFdetalle(Fdetalle fdetalle) {
        fdetalleService.save(fdetalle);
        return "redirect:/fdetalle/listado";
    }

    @GetMapping("/fdetalle/modificar/{idDetalle}")
    public String modificarFdetalle(Fdetalle fdetalle, Model model) {
        fdetalle = fdetalleService.getFdetalle(fdetalle);
        model.addAttribute("fdetalle", fdetalle);
        return "/fdetalle/modificar";
    }

    @GetMapping("/fdetalle/eliminar/{idDetalle}")
    public String eliminarFdetalle(Fdetalle fdetalle) {
        fdetalleService.delete(fdetalle);
        return "redirect:/fdetalle/listado";
    }

}
