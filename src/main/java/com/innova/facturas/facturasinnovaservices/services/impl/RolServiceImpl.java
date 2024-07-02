package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.RolDao;
import com.innova.facturas.facturasinnovaservices.model.dto.RolDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;
import com.innova.facturas.facturasinnovaservices.services.RolService;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolDao rolDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Rol> getAllRols() {
        return (List) rolDao.findAll();
    }

    @Transactional
    @Override
    public Rol save(RolDto rolDto) {

        Rol rol = Rol.builder()
                .idRol(rolDto.getIdRol())
                .nombreRol(rolDto.getNombreRol())
                .statusRol(rolDto.getStatusRol())
                .createdAt(rolDto.getCreatedAt())
                .createdBy(rolDto.getCreatedBy())
                .updatedAt(rolDto.getUpdatedAt())
                .updatedBy(rolDto.getUpdatedBy())
                .build();
        return rolDao.save(rol);
    }

    @Transactional(readOnly = true)
    @Override
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    public boolean existsById(Integer id) {
        return rolDao.existsById(id);
    }
}
