package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.RgfacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rgfactura;

public interface RgfacturaService {

    Rgfactura save(RgfacturaDto rgfacturaDto);

    Rgfactura findById(Integer id);

    void delete(Rgfactura rgfactura);

    List<Rgfactura> getAllRgfacturas();

    List<Rgfactura> findAllOrderASC();

    List<Rgfactura> findAllByRuc(Integer ruc);

    List<Rgfactura> listRg90();

    boolean existsById(Integer id);

}
