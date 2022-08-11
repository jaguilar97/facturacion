package com.Facturacion.service;

import com.Facturacion.domain.Inventario;
import java.util.List;

public interface InventarioService {
    
    public List<Inventario> getinventario();
    
    public Inventario getInventario(Inventario inventario);
    
    public void save(Inventario inventario);
    
    public void delete(Inventario inventario);
    
}
