package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.DetalleAjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.DetalleAjuste;

public interface DetalleAjusteService {

    DetalleAjuste save(DetalleAjusteDto detalleAjusteDto);

    DetalleAjuste findById(Integer id);

    void delete(DetalleAjuste ajuste);

    List<DetalleAjuste> getAllDetalleAjustes();

    List<DetalleAjuste> getDetalleByAjuste(Integer idAjuste);

    boolean existsById(Integer id);

}
