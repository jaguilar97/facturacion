package com.Facturacion.service;

import com.Facturacion.dao.SistemadeenvioDao;
import com.Facturacion.domain.Sistemadeenvio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public abstract class SistemadeenvioServiceImpl implements SistemadeenvioService {
    
    @Autowired
    private SistemadeenvioDao sistemadeenvioDao;

    @Override
    @Transactional(readOnly=true)
    public List<Sistemadeenvio> getSistemadeenvio() {
        var lista = (List<Sistemadeenvio>)sistemadeenvioDao.findAll();
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Sistemadeenvio getSistemadeenvio(Sistemadeenvio sistemadeenvio) {
        return sistemadeenvioDao.findById(Sistemadeenvio.getIdSistemadeenvio()).orElse(null);
    }

    @Override
    public void save(Sistemadeenvio sistemadeenvio) {
        sistemadeenvioDao.save(sistemadeenvio);
    }

    @Override
    public void delete(Sistemadeenvio sistemadeenvio) {
        sistemadeenvioDao.delete(sistemadeenvio);
    }
}