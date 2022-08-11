package com.Facturacion.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="fdetalle")
public class Fdetalle implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    private Long idFactura;
    private Long idProducto;
    private int precio;
    private int cantidad;

    public Fdetalle() {
    }

    public Fdetalle(Long idFactura, Long idProducto, int precio, int cantidad) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    
    
}
