package com.innova.facturas.facturasinnovaservices.services;

import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.dto.ClienteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cliente;

public interface ClienteService {

    Cliente save(ClienteDto cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    List<Cliente> getAllClientes();

    boolean existsById(Integer id);

}
