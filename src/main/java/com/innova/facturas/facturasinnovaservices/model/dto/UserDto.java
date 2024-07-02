package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.innova.facturas.facturasinnovaservices.model.entity.Persona;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;
import com.innova.facturas.facturasinnovaservices.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class UserDto implements Serializable {

    private Integer idUser;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private Rol rol;

    private String username;
    private String password;
    private Timestamp lastLogin;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private Persona persona;

    private String statusUser;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User createdBy;

}
