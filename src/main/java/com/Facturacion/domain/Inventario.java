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
@Table(name="inventario")
public class Inventario implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInventario;
    String Articulo;
    String nombreart;
    String cantidad;
    String codigo;
    

    public Inventario() {
    }

    public Inventario(String Articulo, String nombreart, String cantidad, String codigo) {
        this.Articulo = Articulo;
        this.nombreart = nombreart;
        this.cantidad = cantidad;
        this.codigo = codigo;

    }
    
}
