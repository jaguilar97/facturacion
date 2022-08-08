package com.Facturacion.controller;


import com.Facturacion.domain.Sistemadeenvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SistemadeenvioController {
    
    @Autowired
    private Sistemadeenvio SistemadeenvioService;
    
    @GetMapping("/sistemadeenvio/listado")
    public String inicio(Model model){
        
        var sistemadeenvio=SistemadeenvioService.getsistemadeenvio();
        model.addAttribute("sistemadeenvio", sistemadeenvio);
        
        return "/sistemadeenvio/listado";
    }
    
    @GetMapping("/sistemadeenvio/nuevo")
    public String nuevoInventario(Sistemadeenvio sistemadeenvio){
        return "/sistemadeenvio/modificar";
    }
    
    @PostMapping("/sistemadeenvio/guardar")
    public String guardarInventario(Sistemadeenvio sistemadeenvio){
        SistemadeenvioService.save(sistemadeenvio);
        return "redirect:/sistemadeenvio/listado";
    }
    
    @GetMapping("/sistemadeenvio/modificar/{idSistemadeenvio}")
    public String modificarSistemadeenvio(Sistemadeenvio sistemadeenvio, Model model){
        SistemadeenvioService = sistemadeenvio.getSistemadeenvioService(sistemadeenvio);
        model.addAttribute("sistemadeenvio", sistemadeenvio);
        return "/sistemadeenvio/modificar";
    }
    
    @GetMapping("/sistemadeenvio/eliminar/{idSistemadeenvio}")
    public String eliminarsistemadeenvio(Sistemadeenvio sistemadeenvio){
        SistemadeenvioService.delete(sistemadeenvio);
        return "redirect:/inventario/listado";
    }
    
}
