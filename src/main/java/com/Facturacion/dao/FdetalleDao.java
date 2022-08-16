package com.Facturacion.dao;

import com.Facturacion.domain.Fdetalle;
import com.Facturacion.domain.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface FdetalleDao extends CrudRepository<Fdetalle, Long> {
    
    public Optional<Fdetalle> findByIdFacturaAndProducto(Long idFactura, Producto producto);
    
    public List<Fdetalle> findByIdFactura(Long idFactura);
    
    public void deleteByIdFactura(Long idFactura);
    
}
