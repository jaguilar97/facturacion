package com.Facturacion.service;

import com.Facturacion.domain.Fencabezado;
import java.util.List;

public interface FencabezadoService {
    
    public List<Fencabezado> getFencabezados();
    
    public Fencabezado getFencabezado(Fencabezado fencabezado);
    
    public void save(Fencabezado fencabezado);
    
    public void delete(Fencabezado fencabezado);
    
}
