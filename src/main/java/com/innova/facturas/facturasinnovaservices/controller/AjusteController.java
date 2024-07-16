package com.innova.facturas.facturasinnovaservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innova.facturas.facturasinnovaservices.exception.MensajeResponse;
import com.innova.facturas.facturasinnovaservices.model.dto.AjusteDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Ajuste;
import com.innova.facturas.facturasinnovaservices.services.AjusteService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AjusteController {

    @Autowired
    private AjusteService ajusteService;

    @GetMapping("settings")
    public ResponseEntity<?> showAll() {
        List<Ajuste> ajustes = ajusteService.getAllAjustes();

        if (ajustes == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .objeto(ajustes)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Registros Obtenidos:")
                        .objeto(ajustes)
                        .build(),
                HttpStatus.OK);

    }

    @GetMapping("setting/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {

        Ajuste ajuste = ajusteService.findById(id);

        if (ajuste == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .objeto(ajuste)
                            .build(),
                    HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Registro encontrado:")
                        .objeto(ajuste)
                        .build(),
                HttpStatus.OK);

    }

    @PostMapping("setting")
    public ResponseEntity<?> create(@RequestBody AjusteDto ajusteDto) {
        Ajuste ajusteSave = null;

        try {
            ajusteSave = ajusteService.save(ajusteDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("CREADO")
                    .objeto(AjusteDto.builder()
                            .idAjuste(ajusteSave.getIdAjuste())
                            .empresa(ajusteSave.getEmpresa())
                            .nombreAjuste(ajusteSave.getNombreAjuste())
                            .acronimo(ajusteSave.getAcronimo())
                            .descripcion(ajusteSave.getDescripcion())
                            .status(ajusteSave.getStatus())
                            .createdBy(ajusteSave.getCreatedBy())
                            .createdAt(ajusteSave.getCreatedAt())
                            .updatedBy(ajusteSave.getUpdatedBy())
                            .updatedAt(ajusteSave.getUpdatedAt()))
                    .build(),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("ERROR")
                            .objeto(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @PutMapping("setting/{id}")
    public ResponseEntity<?> update(@RequestBody AjusteDto ajusteDto, @PathVariable Integer id) {

        Ajuste ajusteUpdate = null;
        try {
            if (ajusteService.existsById(id)) {
                ajusteDto.setIdAjuste(id);
                ajusteUpdate = ajusteService.save(ajusteDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("CREADO")
                        .objeto(AjusteDto.builder()
                                .idAjuste(ajusteUpdate.getIdAjuste())
                                .empresa(ajusteUpdate.getEmpresa())
                                .nombreAjuste(ajusteUpdate.getNombreAjuste())
                                .acronimo(ajusteUpdate.getAcronimo())
                                .descripcion(ajusteUpdate.getDescripcion())
                                .status(ajusteUpdate.getStatus())
                                .createdBy(ajusteUpdate.getCreatedBy())
                                .createdAt(ajusteUpdate.getCreatedAt())
                                .updatedBy(ajusteUpdate.getUpdatedBy())
                                .updatedAt(ajusteUpdate.getUpdatedAt()))
                        .build(),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mensaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .objeto(null)
                                .build(),
                        HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("setting/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        try {
            Ajuste ajusteDelete = ajusteService.findById(id);
            if (ajusteDelete == null) {
                return new ResponseEntity<>(ajusteDelete, HttpStatus.NOT_FOUND);
            } else {
                ajusteService.delete(ajusteDelete);
                return new ResponseEntity<>(ajusteDelete, HttpStatus.NO_CONTENT);
            }

        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje(exDt.getMessage())
                            .objeto(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

}
