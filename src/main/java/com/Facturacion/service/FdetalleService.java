package com.Facturacion.service;

import com.Facturacion.domain.Fdetalle;
import com.Facturacion.domain.Producto;
import java.util.List;

public interface FdetalleService {
    
    Fdetalle getFdetalle(Long idFactura, Producto producto);
    
    public List<Fdetalle> getFdetalles();
    
    public Fdetalle getFdetalle(Fdetalle fdetalle);
    
    public void save(Fdetalle fdetalle);
    
    public void delete(Fdetalle fdetalle);
    
    public void deleteAll(Long idFactura);
    
}
