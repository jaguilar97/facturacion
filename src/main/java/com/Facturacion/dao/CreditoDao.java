package com.Facturacion.dao;

import com.Facturacion.domain.Credito;
import org.springframework.data.repository.CrudRepository;

public interface CreditoDao extends CrudRepository<Credito, Long> {
    
}
