package com.Facturacion.dao;

import com.Facturacion.domain.NotaCredito;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface NotaCreditoDao extends CrudRepository<NotaCredito, Long> {
    
    public Optional<NotaCredito> findByIdFactura(Long idFactura);
    
}
