package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.innova.facturas.facturasinnovaservices.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class FacturaDto implements Serializable {

    private Integer idFactura;
    private String tipoFactura;
    private String timbradoFactura;
    private String cdcFactura;
    private String codigoControlFactura;
    private String numeroFactura;
    private String rucEmisorFactura;
    private String razonSocialEmisorFactura;
    private String rucReceptorFactura;
    private String razonSocialReceptorFactura;
    private String condicionVentaFactura;
    private Date fechaInicioVigenciaFactura;
    private Date fechaFinVigenciaFactura;
    private Date fechaEmisionFactura;
    private Double montoTotalFactura;
    private Double montoTotalIvaFactura;
    private Double monto5Factura;
    private Double monto10Factura;
    private Double excentaFactura;
    private String statusFactura;
    private Timestamp createdAt;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User createdBy;
    private Timestamp updatedAt;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User updatedBy;

}
