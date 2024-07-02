package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.RolDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;

public interface RolService {

    Rol save(RolDto rolDto);

    Rol findById(Integer id);

    void delete(Rol rol);

    List<Rol> getAllRols();

    boolean existsById(Integer id);

}
