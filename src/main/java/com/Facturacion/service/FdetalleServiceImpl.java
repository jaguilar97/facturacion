package com.Facturacion.service;

import com.Facturacion.dao.FdetalleDao;
import com.Facturacion.domain.Fdetalle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FdetalleServiceImpl implements FdetalleService {
    
    @Autowired
    private FdetalleDao fdetalleDao;

    @Override
    @Transactional(readOnly=true)
    public List<Fdetalle> getFdetalles() {
        return (List<Fdetalle>)fdetalleDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Fdetalle getFdetalle(Fdetalle fdetalle) {
        return fdetalleDao.findById(fdetalle.getIdFactura()).orElse(null);
    }

    @Override
    public void save(Fdetalle fdetalle) {
        fdetalleDao.save(fdetalle);
    }

    @Override
    public void delete(Fdetalle fdetalle) {
        fdetalleDao.delete(fdetalle);
    }
    
}
