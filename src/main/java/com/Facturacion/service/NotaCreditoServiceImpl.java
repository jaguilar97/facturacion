package com.Facturacion.service;

import com.Facturacion.dao.NotaCreditoDao;
import com.Facturacion.domain.NotaCredito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotaCreditoServiceImpl implements NotaCreditoService {
    
    @Autowired
    private NotaCreditoDao notaCreditoDao;
    
    @Override
    public NotaCredito getNotaCredito(Long idFactura) {
        return notaCreditoDao.findByIdFactura(idFactura).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public List<NotaCredito> getNotaCreditos() {
        return (List<NotaCredito>)notaCreditoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public NotaCredito getNotaCredito(NotaCredito notaCredito) {
        return notaCreditoDao.findById(notaCredito.getIdFactura()).orElse(null);
    }

    @Override
    public void save(NotaCredito notaCredito) {
        notaCreditoDao.save(notaCredito);
    }

    @Override
    public void delete(NotaCredito notaCredito) {
        notaCreditoDao.delete(notaCredito);
    }
    
}
