package com.Facturacion.dao;

import com.Facturacion.domain.NotaCredito;
import org.springframework.data.repository.CrudRepository;

public interface NotaCreditoDao extends CrudRepository<NotaCredito, Long> {
    
}
