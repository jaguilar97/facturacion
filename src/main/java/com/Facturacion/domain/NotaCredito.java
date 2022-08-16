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
@Table(name="ncredito")
public class NotaCredito implements Serializable {
    
    private static final long serialVersionOID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nota")
    private Long idNota;
    private Long idFactura;
    private int monto;

    public NotaCredito() {
    }

    public NotaCredito(Long idFactura, int monto) {
        this.idFactura = idFactura;
        this.monto = monto;
    }
    
    
    
}
