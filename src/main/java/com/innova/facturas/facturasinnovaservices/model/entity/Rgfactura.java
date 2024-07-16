package com.innova.facturas.facturasinnovaservices.model.entity;

import java.io.Serializable;

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
@Table(name = "rgfactura")
public class Rgfactura implements Serializable {

    @Id
    @Column(name = "id_rgfactura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRgFactura;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa empresa;

    @Column(name = "mes_periodo")
    private String mesPeriodo;

    @Column(name = "anho_periodo")
    private String anhoPeriodo;

    @Column(name = "codigo_tipo_registro")
    private String codigoTipoRegistro;

    @Column(name = "codigo_tipo_comprador")
    private String codigoTipoComprador;

    @Column(name = "nro_identificador_comprador")
    private String nroIdentificadorComprador;

    @Column(name = "nombre_comprador")
    private String nombreComprador;

    @Column(name = "codigo_tipo_comprobante")
    private String codigoTipoComprobante;

    @Column(name = "fecha_emision")
    private String fechaEmision;

    @Column(name = "nro_timbrado")
    private String nroTimbrado;

    @Column(name = "nro_comprobante")
    private String nroComprobante;

    @Column(name = "monto_iva_10")
    private String montoIva10;

    @Column(name = "monto_iva_5")
    private String montoIva5;

    @Column(name = "monto_exenta")
    private String montoExenta;

    @Column(name = "monto_total_comprobante")
    private String montoTotalComprobante;

    @Column(name = "condicion_venta")
    private String condicionVenta;

    @Column(name = "moneda_extranjera")
    private String monedaExtranjera;

    @Column(name = "imputa_iva")
    private String imputaIva;

    @Column(name = "imputa_ire")
    private String imputaIre;

    @Column(name = "imputa_irp_rsp")
    private String imputaIrpRsp;

    @Column(name = "comprobante_asociado")
    private String comprobanteAsociado;

    @Column(name = "timbrado_comprobante_asociado")
    private String timbradoComprobanteAsociado;

    @Column(name = "created_by")
    private String createdBy;

    @CreationTimestamp
    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_by")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private String updatedAt;

}
