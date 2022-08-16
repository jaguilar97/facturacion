package com.Facturacion.controller;

import com.Facturacion.domain.Fdetalle;
import com.Facturacion.domain.Fencabezado;
import com.Facturacion.domain.Producto;
import com.Facturacion.service.FdetalleService;
import com.Facturacion.service.FencabezadoService;
import com.Facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FencabezadoController {
   
    @Autowired
    private FencabezadoService fencabezadoService;
    
    @Autowired
    private FdetalleService fdetalleService;

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/fencabezado/listado")
    public String inicio(Model model){
        
        var fencabezados=fencabezadoService.getFencabezados();
        model.addAttribute("totalFencabezados",fencabezados.size());
        model.addAttribute("fencabezados", fencabezados);
        
        return "/fencabezado/listado";
    }
    
    @GetMapping("/fencabezado/nuevo")
    public String nuevoFencabezado(Fencabezado fencabezado){
        return "/fencabezado/modificar";
    }
    
    @PostMapping("/fencabezado/guardar")
    public String guardarFencabezado(Fencabezado fencabezado, Producto producto){
        
        producto = productoService.getProducto(producto);
        fencabezadoService.save(fencabezado);
        Long idFactura = fencabezado.getIdFactura();
        Fdetalle fdetalle = fdetalleService.getFdetalle(idFactura, producto);
        
        if(fdetalle != null) {
            fdetalle.setCantidad(fdetalle.getCantidad() + 1);
        } else {
            fdetalle = new Fdetalle(idFactura, producto, producto.getPrecio(), 1);
        }
        fdetalleService.save(fdetalle);
        return "redirect:/fencabezado/listado";
        
    }
    
    @GetMapping("/fencabezado/modificar/{idFactura}")
    public String modificarFencabezado(Fencabezado fencabezado, Model model){
        fencabezado = fencabezadoService.getFencabezado(fencabezado);
        model.addAttribute("fencabezado", fencabezado);
        return "/fencabezado/modificar";
    }
    
    @GetMapping("/fencabezado/eliminar/{idFactura}")
    public String eliminarFencabezado(Fencabezado fencabezado){
        fencabezadoService.delete(fencabezado);
        fdetalleService.deleteAll(fencabezado.getIdFactura());
        return "redirect:/fencabezado/listado";
    }
    
}
