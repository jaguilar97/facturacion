package com.Facturacion.controller;

import com.Facturacion.domain.Inventario;
import com.Facturacion.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InventarioController {
    
    @Autowired
    private InventarioService inventarioService;
    
    @GetMapping("/inventario/listado")
    public String inicio(Model model){
        
        var inventario=inventarioService.getinventario();
        model.addAttribute("inventario", inventario);
        
        return "/inventario/listado";
    }
    
    @GetMapping("/inventario/nuevo")
    public String nuevoInventario(Inventario inventario){
        return "/inventario/modificar";
    }
    
    @PostMapping("/inventario/guardar")
    public String guardarInventario(Inventario inventario){
        inventarioService.save(inventario);
        return "redirect:/Inventario/listado";
    }
    
    @GetMapping("/inventario/modificar/{idInventario}")
    public String modificarInventario(Inventario inventario, Model model){
        inventario = inventarioService.getInventario(inventario);
        model.addAttribute("inventario", inventario);
        return "/inventario/modificar";
    }
    
    @GetMapping("/inventario/eliminar/{idInventario}")
    public String eliminarinventario(Inventario inventario){
        inventarioService.delete(inventario);
        return "redirect:/inventario/listado";
    }
    
}
