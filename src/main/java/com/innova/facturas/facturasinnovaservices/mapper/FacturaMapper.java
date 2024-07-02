package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.FacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Factura;

public class FacturaMapper {

    public static FacturaDto mapToFacturaDto(Factura factura) {
        return new FacturaDto(
                factura.getIdFactura(),
                factura.getTipoFactura(),
                factura.getTimbradoFactura(),
                factura.getCdcFactura(),
                factura.getCodigoControlFactura(),
                factura.getNumeroFactura(),
                factura.getRucEmisorFactura(),
                factura.getRazonSocialEmisorFactura(),
                factura.getRucReceptorFactura(),
                factura.getRazonSocialReceptorFactura(),
                factura.getCondicionVentaFactura(),
                factura.getFechaInicioVigenciaFactura(),
                factura.getFechaFinVigenciaFactura(),
                factura.getFechaEmisionFactura(),
                factura.getMontoTotalFactura(),
                factura.getMontoTotalIvaFactura(),
                factura.getMonto5Factura(),
                factura.getMonto10Factura(),
                factura.getExcentaFactura(),
                factura.getStatusFactura(),
                factura.getCreatedAt(),
                factura.getCreatedBy(),
                factura.getUpdatedAt(),
                factura.getUpdatedBy());
    }

    public static Factura mapToFactura(FacturaDto facturaDto) {
        return new Factura(
                facturaDto.getIdFactura(),
                facturaDto.getTipoFactura(),
                facturaDto.getTimbradoFactura(),
                facturaDto.getCdcFactura(),
                facturaDto.getCodigoControlFactura(),
                facturaDto.getNumeroFactura(),
                facturaDto.getRucEmisorFactura(),
                facturaDto.getRazonSocialEmisorFactura(),
                facturaDto.getRucReceptorFactura(),
                facturaDto.getRazonSocialReceptorFactura(),
                facturaDto.getCondicionVentaFactura(),
                facturaDto.getFechaInicioVigenciaFactura(),
                facturaDto.getFechaFinVigenciaFactura(),
                facturaDto.getFechaEmisionFactura(),
                facturaDto.getMontoTotalFactura(),
                facturaDto.getMontoTotalIvaFactura(),
                facturaDto.getMonto5Factura(),
                facturaDto.getMonto10Factura(),
                facturaDto.getExcentaFactura(),
                facturaDto.getStatusFactura(),
                facturaDto.getCreatedAt(),
                facturaDto.getCreatedBy(),
                facturaDto.getUpdatedAt(),
                facturaDto.getUpdatedBy());
    }

}
