package com.innova.facturas.facturasinnovaservices.mapper;

import com.innova.facturas.facturasinnovaservices.model.dto.CotizacionDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cotizacion;

public class CotizacionMapper {

    public static CotizacionDto mapToCotizacionDto(Cotizacion cotizacion) {
        return new CotizacionDto(
                cotizacion.getIdCotizacion(),
                cotizacion.getAjuste(),
                cotizacion.getCompra(),
                cotizacion.getVenta(),
                cotizacion.getStatus(),
                cotizacion.getCreatedBy(),
                cotizacion.getCreatedAt(),
                cotizacion.getUpdatedBy(),
                cotizacion.getUpdatedAt());
    }

    public static Cotizacion mapToCotizacion(CotizacionDto cotizacionDto) {
        return new Cotizacion(
                cotizacionDto.getIdCotizacion(),
                cotizacionDto.getAjuste(),
                cotizacionDto.getCompra(),
                cotizacionDto.getVenta(),
                cotizacionDto.getStatus(),
                cotizacionDto.getCreatedBy(),
                cotizacionDto.getCreatedAt(),
                cotizacionDto.getUpdatedBy(),
                cotizacionDto.getUpdatedAt());
    }

}
