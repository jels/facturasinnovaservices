package com.innova.facturas.facturasinnovaservices.model.entity;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

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
    @CreationTimestamp // with this annotation, hibernate will automatically manage the timestamps
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;

    @Column(name = "updated_at")
    @UpdateTimestamp // with this annotation, hibernate will automatically manage the timestamps
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "updated_by", nullable = false)
    private User updatedBy;

}
