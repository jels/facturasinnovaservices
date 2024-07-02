package com.innova.facturas.facturasinnovaservices.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.innova.facturas.facturasinnovaservices.model.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {

}
