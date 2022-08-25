package com.Facturacion.controller;

import com.Facturacion.domain.Producto;
import com.Facturacion.service.CategoriaService;
import com.Facturacion.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {
    
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
    
}
