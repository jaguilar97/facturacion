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
@Table(name="fencabezado")
public class Fencabezado implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFactura;
    private Long idCliente;
    String fecha;
    private int total;

    public Fencabezado() {
    }

    public Fencabezado(Long idCliente, String fecha, int total) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }
    
}
