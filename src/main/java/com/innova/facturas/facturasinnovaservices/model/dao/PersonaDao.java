package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.innova.facturas.facturasinnovaservices.model.entity.Persona;

public interface PersonaDao extends CrudRepository<Persona, Integer> {

}
