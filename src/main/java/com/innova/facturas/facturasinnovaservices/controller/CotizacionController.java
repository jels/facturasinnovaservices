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
import com.innova.facturas.facturasinnovaservices.model.dto.CotizacionDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cotizacion;
import com.innova.facturas.facturasinnovaservices.services.CotizacionService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class CotizacionController {

    @Autowired
    private CotizacionService cotizacionService;

    @GetMapping("cotizaciones")
    public ResponseEntity<?> showAll() {

        List<Cotizacion> cotizacion = cotizacionService.getAllCotizaciones();

        if (cotizacion == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .objeto(cotizacion)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Registros Obtenidos:")
                        .objeto(cotizacion)
                        .build(),
                HttpStatus.OK);
    }

    @GetMapping("cotizacion/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {

        Cotizacion cotizacion = cotizacionService.findById(id);

        if (cotizacion == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("No hay registros")
                            .objeto(cotizacion)
                            .build(),
                    HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mensaje("Registro encontrado:")
                        .objeto(cotizacion)
                        .build(),
                HttpStatus.OK);

    }

    @PostMapping("cotizacion")
    public ResponseEntity<?> create(@RequestBody CotizacionDto cotizacionDto) {
        Cotizacion cotizacionSave = null;

        try {
            cotizacionSave = cotizacionService.save(cotizacionDto);
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("CREADO")
                            .objeto(CotizacionDto.builder()
                                    .idCotizacion(cotizacionSave.getIdCotizacion())
                                    .ajuste(cotizacionSave.getAjuste())
                                    .compra(cotizacionSave.getCompra())
                                    .venta(cotizacionSave.getVenta())
                                    .status(cotizacionSave.getStatus())
                                    .createdBy(cotizacionSave.getCreatedBy())
                                    .createdAt(cotizacionSave.getCreatedAt())
                                    .updatedBy(cotizacionSave.getUpdatedBy())
                                    .updatedAt(cotizacionSave.getUpdatedAt())
                                    .build())
                            .build(),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mensaje("Error al crear cliente")
                            .objeto(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("cotizacion/{id}")
    public ResponseEntity<?> update(@RequestBody CotizacionDto cotizacionDto, @PathVariable Integer id) {

        Cotizacion cotizacionUpdate = null;
        try {
            if (cotizacionService.existsById(id)) {
                cotizacionDto.setIdCotizacion(id);
                cotizacionUpdate = cotizacionService.save(cotizacionDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("ACTUALIZADO")
                        .objeto(CotizacionDto.builder()
                                .idCotizacion(cotizacionUpdate.getIdCotizacion())
                                .ajuste(cotizacionUpdate.getAjuste())
                                .compra(cotizacionUpdate.getCompra())
                                .venta(cotizacionUpdate.getVenta())
                                .status(cotizacionUpdate.getStatus())
                                .createdBy(cotizacionUpdate.getCreatedBy())
                                .createdAt(cotizacionUpdate.getCreatedAt())
                                .updatedBy(cotizacionUpdate.getUpdatedBy())
                                .updatedAt(cotizacionUpdate.getUpdatedAt())
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

    @DeleteMapping("cotizacion/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        try {
            Cotizacion cotizacionDelete = cotizacionService.findById(id);
            if (cotizacionDelete == null) {
                return new ResponseEntity<>(cotizacionDelete, HttpStatus.NOT_FOUND);
            } else {
                cotizacionService.delete(cotizacionDelete);
                return new ResponseEntity<>(cotizacionDelete, HttpStatus.NO_CONTENT);
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
