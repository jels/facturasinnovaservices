package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;

public interface EmpresaDao extends CrudRepository<Empresa, Integer> {

}
