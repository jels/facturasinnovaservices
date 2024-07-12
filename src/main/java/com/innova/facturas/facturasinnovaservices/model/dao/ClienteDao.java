package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.innova.facturas.facturasinnovaservices.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}
