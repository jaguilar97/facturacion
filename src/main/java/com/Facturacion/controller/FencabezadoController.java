package com.Facturacion.controller;

import com.Facturacion.domain.Fdetalle;
import com.Facturacion.domain.Fencabezado;
import com.Facturacion.domain.NotaCredito;
import com.Facturacion.domain.Producto;
import com.Facturacion.service.ClienteService;
import com.Facturacion.service.FacturaReportService;
import com.Facturacion.service.FdetalleService;
import com.Facturacion.service.FencabezadoService;
import com.Facturacion.service.NotaCreditoService;
import com.Facturacion.service.ProductoService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FencabezadoController {
   
    @Autowired
    private FacturaReportService facturaReportService;
    
    @Autowired
    private FencabezadoService fencabezadoService;
    
    @Autowired
    private FdetalleService fdetalleService;

    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private NotaCreditoService notaCreditoService;
    
    @Autowired
    private NotaCreditoService notaService;
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping("/fencabezado/listado")
    public String inicio(Model model){
        
        var fencabezados=fencabezadoService.getFencabezados();
        model.addAttribute("totalFencabezados",fencabezados.size());
        model.addAttribute("fencabezados", fencabezados);
        
        return "/fencabezado/listado";
    }
    
    @GetMapping("/fencabezado/nuevo")
    public String nuevoFencabezado(Fencabezado fencabezado, Model model){
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        
        return "/fencabezado/modificar";
    }
    
    @PostMapping("/fencabezado/guardar")
    public String guardarFencabezado(Fencabezado fencabezado, Producto producto){
        
        producto = productoService.getProducto(producto);
        fencabezado.setTotal(producto.getPrecio());
        fencabezadoService.save(fencabezado);
        
        Long idFactura = fencabezado.getIdFactura();
        Fdetalle fdetalle = fdetalleService.getFdetalle(idFactura, producto);
        int cantidad=1;
        if(fdetalle != null) {
            fdetalle.setCantidad(fdetalle.getCantidad() + 1);
        } else {
            fdetalle = new Fdetalle(idFactura, producto, producto.getPrecio()*cantidad, cantidad);
        }
        fdetalleService.save(fdetalle);
        producto.setExistencias(producto.getExistencias()+fdetalle.getCantidad());
        productoService.save(producto);
        return "redirect:/fencabezado/listado";
        
    }
    
    @PostMapping("/nota/guardar")
    public String guardarNota(Fencabezado fencabezado, NotaCredito notaCredito){
        
        notaCreditoService.save(notaCredito);
        fencabezado.setTotal(fencabezado.getTotal()-notaCredito.getMonto());
        fencabezadoService.save(fencabezado);
        
        return "redirect:/fencabezado/listado";
        
    }
    
    @GetMapping("/fencabezado/modificar/{idFactura}")
    public String modificarFencabezado(Fencabezado fencabezado, NotaCredito notaCredito, Model model){
        
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        
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
    
    @GetMapping(value = "/fencabezado/ListadoFacturas", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(facturaReportService.generateReport()));
            byte[] targetArray = new byte[fis.available()];
            fis.read(targetArray);
            return targetArray;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
