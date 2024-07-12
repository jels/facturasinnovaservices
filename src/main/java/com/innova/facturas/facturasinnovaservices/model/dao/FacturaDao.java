package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.Factura;

@Repository
public interface FacturaDao extends CrudRepository<Factura, Integer> {

}
