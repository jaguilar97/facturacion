package com.Facturacion.domain;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="fencabezado")
public class Fencabezado implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_factura")
    private Long idFactura;
    private Long idCliente;
    Date fecha;
    private int total;

    public Fencabezado() {
    }

    public Fencabezado(Long idCliente, Date fecha, int total) {
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }
    
}
