package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.innova.facturas.facturasinnovaservices.model.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class RolDto implements Serializable {

    private Integer idRol;
    private String nombreRol;
    private String statusRol;
    private Timestamp createdAt;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User createdBy;
    private Timestamp updatedAt;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User updatedBy;

}
