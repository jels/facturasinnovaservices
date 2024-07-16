package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.Cotizacion;

@Repository
public interface CotizacionDao extends CrudRepository<Cotizacion, Integer> {

}
