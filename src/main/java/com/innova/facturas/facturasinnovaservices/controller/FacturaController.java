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
import com.innova.facturas.facturasinnovaservices.model.dto.FacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Factura;
import com.innova.facturas.facturasinnovaservices.services.FacturaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class FacturaController {

        @Autowired
        private FacturaService facturaService;

        @GetMapping("facturas")
        public ResponseEntity<?> showAll() {

                List<Factura> facturas = facturaService.getAllFacturas();

                if (facturas == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(facturas)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(facturas)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("factura/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Factura factura = facturaService.findById(id);

                if (factura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(factura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(factura)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("factura")
        public ResponseEntity<?> create(@RequestBody FacturaDto facturaDto) {
                Factura facturaSave = null;
                try {
                        facturaSave = facturaService.save(facturaDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Usuario creado")
                                                        .objeto(
                                                                        FacturaDto.builder()
                                                                                        .idFactura(facturaSave
                                                                                                        .getIdFactura())
                                                                                        .tipoFactura(facturaSave
                                                                                                        .getTipoFactura())
                                                                                        .timbradoFactura(facturaSave
                                                                                                        .getTimbradoFactura())
                                                                                        .cdcFactura(facturaSave
                                                                                                        .getCdcFactura())
                                                                                        .codigoControlFactura(
                                                                                                        facturaSave.getCodigoControlFactura())
                                                                                        .numeroFactura(facturaSave
                                                                                                        .getNumeroFactura())
                                                                                        .rucEmisorFactura(facturaSave
                                                                                                        .getRucEmisorFactura())
                                                                                        .razonSocialEmisorFactura(
                                                                                                        facturaSave.getRazonSocialEmisorFactura())
                                                                                        .rucReceptorFactura(facturaSave
                                                                                                        .getRucReceptorFactura())
                                                                                        .razonSocialReceptorFactura(
                                                                                                        facturaSave.getRazonSocialReceptorFactura())
                                                                                        .condicionVentaFactura(
                                                                                                        facturaSave.getCondicionVentaFactura())
                                                                                        .fechaInicioVigenciaFactura(
                                                                                                        facturaSave.getFechaInicioVigenciaFactura())
                                                                                        .fechaFinVigenciaFactura(
                                                                                                        facturaSave.getFechaFinVigenciaFactura())
                                                                                        .fechaEmisionFactura(facturaSave
                                                                                                        .getFechaEmisionFactura())
                                                                                        .montoTotalFactura(facturaSave
                                                                                                        .getMontoTotalFactura())
                                                                                        .montoTotalIvaFactura(
                                                                                                        facturaSave.getMontoTotalIvaFactura())
                                                                                        .monto5Factura(facturaSave
                                                                                                        .getMonto5Factura())
                                                                                        .monto10Factura(facturaSave
                                                                                                        .getMonto10Factura())
                                                                                        .excentaFactura(facturaSave
                                                                                                        .getExcentaFactura())
                                                                                        .statusFactura(facturaSave
                                                                                                        .getStatusFactura())
                                                                                        .createdBy(facturaSave
                                                                                                        .getCreatedBy())
                                                                                        .createdAt(facturaSave
                                                                                                        .getCreatedAt())
                                                                                        .updatedAt(facturaSave
                                                                                                        .getUpdatedAt())
                                                                                        .updatedBy(facturaSave
                                                                                                        .getUpdatedBy())
                                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear Factura")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("factura/{id}")
        public ResponseEntity<?> update(@RequestBody FacturaDto facturaDto, @PathVariable Integer id) {

                Factura facturaUpdate = null;
                try {
                        if (facturaService.existsById(id)) {
                                facturaDto.setIdFactura(id);
                                facturaUpdate = facturaService.save(facturaDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(FacturaDto.builder()
                                                                .idFactura(facturaUpdate.getIdFactura())
                                                                .tipoFactura(facturaUpdate.getTipoFactura())
                                                                .timbradoFactura(facturaUpdate.getTimbradoFactura())
                                                                .cdcFactura(facturaUpdate.getCdcFactura())
                                                                .codigoControlFactura(
                                                                                facturaUpdate.getCodigoControlFactura())
                                                                .numeroFactura(facturaUpdate.getNumeroFactura())
                                                                .rucEmisorFactura(facturaUpdate.getRucEmisorFactura())
                                                                .razonSocialEmisorFactura(facturaUpdate
                                                                                .getRazonSocialEmisorFactura())
                                                                .rucReceptorFactura(
                                                                                facturaUpdate.getRucReceptorFactura())
                                                                .razonSocialReceptorFactura(facturaUpdate
                                                                                .getRazonSocialReceptorFactura())
                                                                .condicionVentaFactura(facturaUpdate
                                                                                .getCondicionVentaFactura())
                                                                .fechaInicioVigenciaFactura(facturaUpdate
                                                                                .getFechaInicioVigenciaFactura())
                                                                .fechaFinVigenciaFactura(facturaUpdate
                                                                                .getFechaFinVigenciaFactura())
                                                                .fechaEmisionFactura(
                                                                                facturaUpdate.getFechaEmisionFactura())
                                                                .montoTotalFactura(facturaUpdate.getMontoTotalFactura())
                                                                .montoTotalIvaFactura(
                                                                                facturaUpdate.getMontoTotalIvaFactura())
                                                                .monto5Factura(facturaUpdate.getMonto5Factura())
                                                                .monto10Factura(facturaUpdate.getMonto10Factura())
                                                                .excentaFactura(facturaUpdate.getExcentaFactura())
                                                                .statusFactura(facturaUpdate.getStatusFactura())
                                                                .createdBy(facturaUpdate.getCreatedBy())
                                                                .createdAt(facturaUpdate.getCreatedAt())
                                                                .updatedAt(facturaUpdate.getUpdatedAt())
                                                                .updatedBy(facturaUpdate.getUpdatedBy())
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

        @DeleteMapping("factura/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Factura facturaDelete = facturaService.findById(id);
                        if (facturaDelete == null) {
                                return new ResponseEntity<>(facturaDelete, HttpStatus.NOT_FOUND);
                        } else {
                                facturaService.delete(facturaDelete);
                                return new ResponseEntity<>(facturaDelete, HttpStatus.NO_CONTENT);
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
