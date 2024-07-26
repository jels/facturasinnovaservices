package com.innova.facturas.facturasinnovaservices.model.dto;

import java.io.Serializable;
import java.util.List;

import com.innova.facturas.facturasinnovaservices.model.entity.Empresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
public class AjusteDetalleDto implements Serializable {

    private Integer idAjuste;
    private Empresa empresa;
    private String nombreAjuste;
    private String acronimo;
    private String descripcion;
    private String status;
    private List<DetalleAjusteDto> detalles;

}
