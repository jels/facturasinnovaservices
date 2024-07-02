package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.innova.facturas.facturasinnovaservices.model.entity.Factura;

public interface FacturaDao extends CrudRepository<Factura, Integer> {

}
