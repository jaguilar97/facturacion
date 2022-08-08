package com.Facturacion.service;

import com.Facturacion.domain.Producto;
import com.Facturacion.domain.Sistemadeenvio;
import java.util.List;

public interface SistemadeenvioService {
    
    public List<Sistemadeenvio> getSistemadeenvios();
    
    public Producto getSistemadeenvios(Sistemadeenvio sistemadeenvio);
    
    public void save(Sistemadeenvio sistemadeenvio );
    
    public void delete(Sistemadeenvio sistemadeenvio);
    
}
