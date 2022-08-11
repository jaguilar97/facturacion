package com.Facturacion.service;

import com.Facturacion.domain.Fdetalle;
import java.util.List;

public interface FdetalleService {
    
    public List<Fdetalle> getFdetalles();
    
    public Fdetalle getFdetalle(Fdetalle fdetalle);
    
    public void save(Fdetalle fdetalle);
    
    public void delete(Fdetalle fdetalle);
    
}
