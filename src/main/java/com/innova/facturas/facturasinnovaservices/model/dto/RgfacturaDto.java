package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class RgfacturaDto implements Serializable {

    private Integer idRgFactura;
    private Empresa empresa;
    private String ruc;
    private String razonSocial;
    private String mesPeriodo;
    private String anhoPeriodo;
    private String codigoTipoRegistro;
    private String codigoTipoComprador;
    private String nroIdentificadorComprador;
    private String nombreComprador;
    private String codigoTipoComprobante;
    private String fechaEmision;
    private String nroTimbrado;
    private String nroComprobante;
    private String montoIva10;
    private String montoIva5;
    private String montoExenta;
    private String montoTotalComprobante;
    private String condicionVenta;
    private String monedaExtranjera;
    private String imputaIva;
    private String imputaIre;
    private String imputaIrpRsp;
    private String comprobanteAsociado;
    private String timbradoComprobanteAsociado;
    private String createdBy;
    @CreationTimestamp
    private String createdAt;
    private String updatedBy;
    @UpdateTimestamp
    private String updatedAt;

}
