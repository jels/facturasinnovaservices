package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.RgfacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rgfactura;

public class RgfacturaMapper {

    public static RgfacturaDto mapToRgfacturaDto(Rgfactura rgfactura) {
        return new RgfacturaDto(
                rgfactura.getIdRgFactura(),
                rgfactura.getEmpresa(),
                rgfactura.getRuc(),
                rgfactura.getRazonSocial(),
                rgfactura.getMesPeriodo(),
                rgfactura.getAnhoPeriodo(),
                rgfactura.getCodigoTipoRegistro(),
                rgfactura.getCodigoTipoComprador(),
                rgfactura.getNroIdentificadorComprador(),
                rgfactura.getNombreComprador(),
                rgfactura.getCodigoTipoComprobante(),
                rgfactura.getFechaEmision(),
                rgfactura.getNroTimbrado(),
                rgfactura.getNroComprobante(),
                rgfactura.getMontoIva10(),
                rgfactura.getMontoIva5(),
                rgfactura.getMontoExenta(),
                rgfactura.getMontoTotalComprobante(),
                rgfactura.getCondicionVenta(),
                rgfactura.getMonedaExtranjera(),
                rgfactura.getImputaIva(),
                rgfactura.getImputaIre(),
                rgfactura.getImputaIrpRsp(),
                rgfactura.getComprobanteAsociado(),
                rgfactura.getTimbradoComprobanteAsociado(),
                rgfactura.getCreatedBy(),
                rgfactura.getCreatedAt(),
                rgfactura.getUpdatedBy(),
                rgfactura.getUpdatedAt());
    }

    public static Rgfactura mapToRgfactura(RgfacturaDto rgfacturaDto) {
        return new Rgfactura(
                rgfacturaDto.getIdRgFactura(),
                rgfacturaDto.getEmpresa(),
                rgfacturaDto.getRuc(),
                rgfacturaDto.getRazonSocial(),
                rgfacturaDto.getMesPeriodo(),
                rgfacturaDto.getAnhoPeriodo(),
                rgfacturaDto.getCodigoTipoRegistro(),
                rgfacturaDto.getCodigoTipoComprador(),
                rgfacturaDto.getNroIdentificadorComprador(),
                rgfacturaDto.getNombreComprador(),
                rgfacturaDto.getCodigoTipoComprobante(),
                rgfacturaDto.getFechaEmision(),
                rgfacturaDto.getNroTimbrado(),
                rgfacturaDto.getNroComprobante(),
                rgfacturaDto.getMontoIva10(),
                rgfacturaDto.getMontoIva5(),
                rgfacturaDto.getMontoExenta(),
                rgfacturaDto.getMontoTotalComprobante(),
                rgfacturaDto.getCondicionVenta(),
                rgfacturaDto.getMonedaExtranjera(),
                rgfacturaDto.getImputaIva(),
                rgfacturaDto.getImputaIre(),
                rgfacturaDto.getImputaIrpRsp(),
                rgfacturaDto.getComprobanteAsociado(),
                rgfacturaDto.getTimbradoComprobanteAsociado(),
                rgfacturaDto.getCreatedBy(),
                rgfacturaDto.getCreatedAt(),
                rgfacturaDto.getUpdatedBy(),
                rgfacturaDto.getUpdatedAt());
    }
}
