package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;
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
    private Empresa empresa;
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
    @CreationTimestamp
    private Date createdAt;
    private User createdBy;
    @UpdateTimestamp
    private Date updatedAt;
    private User updatedBy;

}
