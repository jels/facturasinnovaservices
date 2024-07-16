package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.CotizacionDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cotizacion;

public interface CotizacionService {

    Cotizacion save(CotizacionDto cotizacionDto);

    Cotizacion findById(Integer id);

    void delete(Cotizacion cotizacion);

    List<Cotizacion> getAllCotizaciones();

    boolean existsById(Integer id);

}
