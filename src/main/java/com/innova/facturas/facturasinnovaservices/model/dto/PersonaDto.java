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
public class PersonaDto implements Serializable {

    private Integer idPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String telefonoPersona;
    private String ciPersona;
    private String statusPersona;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User createdBy;
    private Timestamp createdAt;
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JsonIgnore
    private User updatedBy;
    private Timestamp updatedAt;

}
