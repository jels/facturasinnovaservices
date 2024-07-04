package com.innova.facturas.facturasinnovaservices.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "factura")
public class Factura implements Serializable {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(name = "tipo_factura")
    private String tipoFactura;

    @Column(name = "timbrado_factura")
    private String timbradoFactura;

    @Column(name = "cdc_factura")
    private String cdcFactura;

    @Column(name = "codigo_control_factura")
    private String codigoControlFactura;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "ruc_emisor_factura")
    private String rucEmisorFactura;

    @Column(name = "razon_social_emisor_factura")
    private String razonSocialEmisorFactura;

    @Column(name = "ruc_receptor_factura")
    private String rucReceptorFactura;

    @Column(name = "razon_social_receptor_factura")
    private String razonSocialReceptorFactura;

    @Column(name = "condicion_venta_factura")
    private String condicionVentaFactura;

    @Column(name = "fecha_inicio_vigencia_factura")
    private Date fechaInicioVigenciaFactura;

    @Column(name = "fecha_fin_vigencia_factura")
    private Date fechaFinVigenciaFactura;

    @Column(name = "fecha_emision_factura")
    private Date fechaEmisionFactura;

    @Column(name = "monto_total_factura")
    private Double montoTotalFactura;

    @Column(name = "monto_total_iva_factura")
    private Double montoTotalIvaFactura;

    @Column(name = "monto_5_factura")
    private Double monto5Factura;

    @Column(name = "monto_10_factura")
    private Double monto10Factura;

    @Column(name = "excenta_factura")
    private Double excentaFactura;

    @Column(name = "status_factura")
    private String statusFactura;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    private User updatedBy;

}
