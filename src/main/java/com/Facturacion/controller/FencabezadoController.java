package com.Facturacion.controller;

import com.Facturacion.domain.Fencabezado;
import com.Facturacion.service.FencabezadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FencabezadoController {
   
    @Autowired
    private FencabezadoService fencabezadoService;
    
    @GetMapping("/fencabezado/listado")
    public String inicio(Model model){
        
        var fencabezados=fencabezadoService.getFencabezados();
        model.addAttribute("fencabezados", fencabezados);
        
        return "/fencabezado/listado";
    }
    
    @GetMapping("/fencabezado/nuevo")
    public String nuevoFencabezado(Fencabezado fencabezado){
        return "/fencabezado/modificar";
    }
    
    @PostMapping("/fencabezado/guardar")
    public String guardarFencabezado(Fencabezado fencabezado){
        fencabezadoService.save(fencabezado);
        return "redirect:/fencabezado/listado";
    }
    
    @GetMapping("/fencabezado/modificar/{idFencabezado}")
    public String modificarFencabezado(Fencabezado fencabezado, Model model){
        fencabezado = fencabezadoService.getFencabezado(fencabezado);
        model.addAttribute("fencabezado", fencabezado);
        return "/fencabezado/modificar";
    }
    
    @GetMapping("/fencabezado/eliminar/{idFencabezado}")
    public String eliminarFencabezado(Fencabezado fencabezado){
        fencabezadoService.delete(fencabezado);
        return "redirect:/fencabezado/listado";
    }
    
}
