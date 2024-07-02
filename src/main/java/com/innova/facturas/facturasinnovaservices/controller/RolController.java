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
import com.innova.facturas.facturasinnovaservices.model.dto.RolDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rol;
import com.innova.facturas.facturasinnovaservices.services.RolService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class RolController {

        @Autowired
        private RolService rolService;

        @GetMapping("roles")
        public ResponseEntity<?> showAll() {

                List<Rol> roles = rolService.getAllRols();

                if (roles == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(roles)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(roles)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("rol/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Rol rol = rolService.findById(id);

                if (rol == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(rol)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(
                                                                RolDto.builder()
                                                                                .idRol(rol.getIdRol())
                                                                                .nombreRol(rol.getNombreRol())
                                                                                .statusRol(rol.getStatusRol())
                                                                                .createdAt(rol.getCreatedAt())
                                                                                .createdBy(rol.getCreatedBy())
                                                                                .updatedAt(rol.getUpdatedAt())
                                                                                .updatedBy(rol.getUpdatedBy())
                                                                                .build())
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("rol")
        public ResponseEntity<?> create(@RequestBody RolDto rolDto) {
                Rol rolSave = null;

                try {
                        rolSave = rolService.save(rolDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Usuario creado")
                                                        .objeto(
                                                                        RolDto.builder()
                                                                                        .idRol(rolSave.getIdRol())
                                                                                        .nombreRol(rolSave
                                                                                                        .getNombreRol())
                                                                                        .statusRol(rolSave
                                                                                                        .getStatusRol())
                                                                                        .createdAt(rolSave
                                                                                                        .getCreatedAt())
                                                                                        .createdBy(rolSave
                                                                                                        .getCreatedBy())
                                                                                        .updatedAt(rolSave
                                                                                                        .getUpdatedAt())
                                                                                        .updatedBy(rolSave
                                                                                                        .getUpdatedBy())
                                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear Rol")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("rol/{id}")
        public ResponseEntity<?> update(@RequestBody RolDto rolDto, @PathVariable Integer id) {

                Rol rolUpdate = null;
                try {
                        if (rolService.existsById(id)) {
                                rolDto.setIdRol(id);
                                rolUpdate = rolService.save(rolDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(RolDto.builder()
                                                                .idRol(rolUpdate.getIdRol())
                                                                .nombreRol(rolUpdate.getNombreRol())
                                                                .statusRol(rolUpdate.getStatusRol())
                                                                .createdAt(rolUpdate.getCreatedAt())
                                                                .createdBy(rolUpdate.getCreatedBy())
                                                                .updatedAt(rolUpdate.getUpdatedAt())
                                                                .updatedBy(rolUpdate.getUpdatedBy())
                                                                .build())
                                                .build(), HttpStatus.CREATED);
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

        @DeleteMapping("rol/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Rol rolDelete = rolService.findById(id);
                        if (rolDelete == null) {
                                return new ResponseEntity<>(rolDelete, HttpStatus.NOT_FOUND);
                        } else {
                                rolService.delete(rolDelete);
                                return new ResponseEntity<>(rolDelete, HttpStatus.NO_CONTENT);
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
