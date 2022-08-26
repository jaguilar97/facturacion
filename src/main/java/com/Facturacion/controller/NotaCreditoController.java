package com.Facturacion.controller;

import com.Facturacion.domain.Fencabezado;
import com.Facturacion.domain.NotaCredito;
import com.Facturacion.service.NotaCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class NotaCreditoController {
    
    @Autowired
    private NotaCreditoService notaCreditoService;
    
    @GetMapping("/notaCredito/listado")
    public String inicio(Model model){
        
        var notasCredito=notaCreditoService.getNotasCredito();
        model.addAttribute("totalNotasCredito",notasCredito.size());
        model.addAttribute("notasCredito", notasCredito);
        
        return "/notaCredito/listado";
    }
    
    @PostMapping("/notaCredito/guardar")
    public String guardarFencabezado(NotaCredito notaCredito){
        notaCreditoService.save(notaCredito);
        return "redirect:/";
        
    }
    
}
