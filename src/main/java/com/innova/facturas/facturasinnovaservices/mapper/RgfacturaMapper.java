package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.RgfacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rgfactura;

public class RgfacturaMapper {

    public static RgfacturaDto mapToRgfacturaDto(Rgfactura fgfactura) {
        return new RgfacturaDto(
                fgfactura.getIdRgFactura(),
                fgfactura.getEmpresa(),
                fgfactura.getMesPeriodo(),
                fgfactura.getAnhoPeriodo(),
                fgfactura.getCodigoTipoRegistro(),
                fgfactura.getCodigoTipoComprador(),
                fgfactura.getNroIdentificadorComprador(),
                fgfactura.getNombreComprador(),
                fgfactura.getCodigoTipoComprobante(),
                fgfactura.getFechaEmision(),
                fgfactura.getNroTimbrado(),
                fgfactura.getNroComprobante(),
                fgfactura.getMontoIva10(),
                fgfactura.getMontoIva5(),
                fgfactura.getMontoExenta(),
                fgfactura.getMontoTotalComprobante(),
                fgfactura.getCondicionVenta(),
                fgfactura.getMonedaExtranjera(),
                fgfactura.getImputaIva(),
                fgfactura.getImputaIre(),
                fgfactura.getImputaIrpRsp(),
                fgfactura.getComprobanteAsociado(),
                fgfactura.getTimbradoComprobanteAsociado(),
                fgfactura.getCreatedBy(),
                fgfactura.getCreatedAt(),
                fgfactura.getUpdatedBy(),
                fgfactura.getUpdatedAt());
    }

    public static Rgfactura mapToRgfactura(RgfacturaDto rgfacturaDto) {
        return new Rgfactura(
                rgfacturaDto.getIdRgFactura(),
                rgfacturaDto.getEmpresa(),
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
