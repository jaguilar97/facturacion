package com.Facturacion.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    private Long idCategoria;
    private String descripcion;
    private int precio;
    private int existencias;

    public Producto() {
    }

    public Producto(Long idCategoria, String descripcion, int precio, int existencias) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencias = existencias;
    }
    
}
