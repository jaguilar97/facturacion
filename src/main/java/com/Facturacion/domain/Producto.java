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
@Table(name="producto")
public class Producto implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
    private Long idCategoria;
    private String descripcion;
    private int precio;
    private int exitencias;

    public Producto() {
    }

    public Producto(Long idCategoria, String descripcion, int precio, int exitencias) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.precio = precio;
        this.exitencias = exitencias;
    }
    
}
