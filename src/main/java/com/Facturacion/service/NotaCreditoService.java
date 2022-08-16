package com.Facturacion.service;

import com.Facturacion.domain.NotaCredito;
import java.util.List;

public interface NotaCreditoService {
    
    public List<NotaCredito> getNotaCreditos();
    
    public NotaCredito getNotaCredito(NotaCredito notaCredito);
    
    public void save(NotaCredito notaCredito);
    
    public void delete(NotaCredito notaCredito);
    
}
