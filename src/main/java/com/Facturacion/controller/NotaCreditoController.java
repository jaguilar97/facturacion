package com.Facturacion.controller;

import com.Facturacion.domain.Fencabezado;
import com.Facturacion.domain.NotaCredito;
import com.Facturacion.service.FencabezadoService;
import com.Facturacion.service.NotaCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class NotaCreditoController {
    
    @Autowired
    private NotaCreditoService notaCreditoService;
    
    @Autowired
    private FencabezadoService fencabezadoService;
    
    @GetMapping("/notaCredito/listado")
    public String inicio(Model model){
        
        var notasCredito=notaCreditoService.getNotaCreditos();
        model.addAttribute("totalNotasCredito",notasCredito.size());
        model.addAttribute("notasCredito", notasCredito);
        
        return "/notaCredito/listado";
    }
    
    @PostMapping("/notaCredito/guardar")
    public String guardarFencabezado(NotaCredito notaCredito, Fencabezado fencabezado){
        
        fencabezado = fencabezadoService.getFencabezado(fencabezado);
        notaCreditoService.save(notaCredito);
        
        fencabezado.setTotal(fencabezado.getTotal()-notaCredito.getMonto());
        
        notaCreditoService.save(notaCredito);
        return "redirect:/notaCredito/listado";
        
    }
    
    @GetMapping("/notaCredito/eliminar/{idFactura}")
    public String eliminarNotaCredito(NotaCredito notaCredito){
        notaCreditoService.delete(notaCredito);
        return "redirect:/notaCredito/listado";
    }
    
}
