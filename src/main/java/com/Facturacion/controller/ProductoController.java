package com.Facturacion.controller;

import com.Facturacion.domain.Producto;
import com.Facturacion.service.CategoriaService;
import com.Facturacion.service.ProductoReportService;
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
public class ProductoController {
    
    @Autowired
    private ProductoReportService productoReportService;
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/producto/listado")
    public String inicio(Model model){
        
        var productos=productoService.getProductos();
        model.addAttribute("productos", productos);
        model.addAttribute("totalProductos",productos.size());
        
        return "/producto/listado";
    }
    
    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto, Model model){
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        return "/producto/modificar";
    }
    
    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto){
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/producto/modificar/{idProducto}")
    public String modificarProducto(Producto producto, Model model){
        var categorias = categoriaService.getCategorias();
        model.addAttribute("categorias", categorias);
        
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";
    }
    
    @GetMapping("/producto/eliminar/{idProducto}")
    public String eliminarProducto(Producto producto){
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping(value = "/producto/ListadoProductos", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody
    byte[] getFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream(new File(productoReportService.generateReport()));
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
