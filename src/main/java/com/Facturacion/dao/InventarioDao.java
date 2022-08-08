package com.Facturacion.dao;

import com.Facturacion.domain.Inventario;
import org.springframework.data.repository.CrudRepository;

public interface InventarioDao extends CrudRepository<Inventario, Long> {
    
}
