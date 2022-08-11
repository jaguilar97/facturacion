package com.Facturacion.service;

import com.Facturacion.dao.InventarioDao;
import com.Facturacion.domain.Inventario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventarioServiceImpl implements InventarioService {
    
    @Autowired
    private InventarioDao inventarioDao;

    @Transactional(readOnly=true)
    public List<Inventario> getInventario() {
        return (List<Inventario>)inventarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Inventario getInventario(Inventario inventario) {
        return inventarioDao.findById(inventario.getIdInventario()).orElse(null);
    }

    @Override
    public void save(Inventario inventario) {
        inventarioDao.save(inventario);
    }

    @Override
    public void delete(Inventario inventario) {
        inventarioDao.delete(inventario);
    }

    @Override
    public List<Inventario> getinventario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
