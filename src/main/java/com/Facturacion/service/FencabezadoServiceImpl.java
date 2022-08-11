package com.Facturacion.service;

import com.Facturacion.dao.FencabezadoDao;
import com.Facturacion.domain.Fencabezado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FencabezadoServiceImpl implements FencabezadoService {
    
    @Autowired
    private FencabezadoDao fencabezadoDao;

    @Override
    @Transactional(readOnly=true)
    public List<Fencabezado> getFencabezados() {
        return (List<Fencabezado>)fencabezadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Fencabezado getFencabezado(Fencabezado fencabezado) {
        return fencabezadoDao.findById(fencabezado.getIdFactura()).orElse(null);
    }

    @Override
    public void save(Fencabezado fencabezado) {
        fencabezadoDao.save(fencabezado);
    }

    @Override
    public void delete(Fencabezado fencabezado) {
        fencabezadoDao.delete(fencabezado);
    }
    
}
