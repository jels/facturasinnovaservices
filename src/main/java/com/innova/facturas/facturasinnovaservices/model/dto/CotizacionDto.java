package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class CotizacionDto implements Serializable {

    private Integer idCotizacion;
    private Ajuste ajuste;
    private Double compra;
    private Double venta;
    private String status;
    private Integer createdBy;
    @CreationTimestamp
    private Timestamp createdAt;
    private Integer updatedBy;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
