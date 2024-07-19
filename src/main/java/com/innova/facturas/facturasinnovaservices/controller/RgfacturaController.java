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
import com.innova.facturas.facturasinnovaservices.model.dto.RgfacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rgfactura;
import com.innova.facturas.facturasinnovaservices.services.RgfacturaService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class RgfacturaController {

        @Autowired
        private RgfacturaService rgfacturaService;

        @GetMapping("rgfacturas")
        public ResponseEntity<?> showAll() {

                List<Rgfactura> rgfactura = rgfacturaService.getAllRgfacturas();

                if (rgfactura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(rgfactura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(rgfactura)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("rgfacturasasc")
        public ResponseEntity<?> showAllORderASC() {

                List<Rgfactura> rgfactura = rgfacturaService.findAllOrderASC();

                if (rgfactura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(rgfactura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);
                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registros Obtenidos:")
                                                .objeto(rgfactura)
                                                .build(),
                                HttpStatus.OK);
        }

        @GetMapping("rgfactura/{id}")
        public ResponseEntity<?> showById(@PathVariable Integer id) {

                Rgfactura rgfactura = rgfacturaService.findById(id);

                if (rgfactura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(rgfactura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(rgfactura)
                                                .build(),
                                HttpStatus.OK);

        }

        @GetMapping("listrgfacturas")
        public ResponseEntity<?> listRg90() {

                List<Rgfactura> rgfactura = rgfacturaService.listRg90();

                if (rgfactura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(rgfactura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(rgfactura)
                                                .build(),
                                HttpStatus.OK);

        }

        @GetMapping("rgfacturaruc/{ruc}")
        public ResponseEntity<?> showByRuc(@PathVariable Integer ruc) {

                List<Rgfactura> rgfactura = rgfacturaService.findAllByRuc(ruc);

                if (rgfactura == null) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("No hay registros")
                                                        .objeto(rgfactura)
                                                        .build(),
                                        HttpStatus.NOT_FOUND);

                }

                return new ResponseEntity<>(
                                MensajeResponse.builder()
                                                .mensaje("Registro encontrado:")
                                                .objeto(rgfactura)
                                                .build(),
                                HttpStatus.OK);

        }

        @PostMapping("rgfactura")
        public ResponseEntity<?> create(@RequestBody RgfacturaDto rgfacturaDto) {
                Rgfactura rgfacturaSave = null;

                try {
                        rgfacturaSave = rgfacturaService.save(rgfacturaDto);
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Usuario creado")
                                                        .objeto(
                                                                        RgfacturaDto.builder()
                                                                                        .idRgFactura(rgfacturaSave
                                                                                                        .getIdRgFactura())
                                                                                        .empresa(rgfacturaSave
                                                                                                        .getEmpresa())
                                                                                        .ruc(rgfacturaSave
                                                                                                        .getRuc())
                                                                                        .razonSocial(rgfacturaSave
                                                                                                        .getRazonSocial())
                                                                                        .mesPeriodo(rgfacturaSave
                                                                                                        .getMesPeriodo())
                                                                                        .anhoPeriodo(rgfacturaSave
                                                                                                        .getAnhoPeriodo())
                                                                                        .codigoTipoRegistro(
                                                                                                        rgfacturaSave.getCodigoTipoRegistro())
                                                                                        .codigoTipoComprador(
                                                                                                        rgfacturaSave.getCodigoTipoComprador())
                                                                                        .nroIdentificadorComprador(
                                                                                                        rgfacturaSave.getNroIdentificadorComprador())
                                                                                        .nombreComprador(rgfacturaSave
                                                                                                        .getNombreComprador())
                                                                                        .codigoTipoComprobante(
                                                                                                        rgfacturaSave.getCodigoTipoComprobante())
                                                                                        .fechaEmision(rgfacturaSave
                                                                                                        .getFechaEmision())
                                                                                        .nroTimbrado(rgfacturaSave
                                                                                                        .getNroTimbrado())
                                                                                        .nroComprobante(rgfacturaSave
                                                                                                        .getNroComprobante())
                                                                                        .montoIva10(rgfacturaSave
                                                                                                        .getMontoIva10())
                                                                                        .montoIva5(rgfacturaSave
                                                                                                        .getMontoIva5())
                                                                                        .montoExenta(rgfacturaSave
                                                                                                        .getMontoExenta())
                                                                                        .montoTotalComprobante(
                                                                                                        rgfacturaSave.getMontoTotalComprobante())
                                                                                        .condicionVenta(rgfacturaSave
                                                                                                        .getCondicionVenta())
                                                                                        .monedaExtranjera(rgfacturaSave
                                                                                                        .getMonedaExtranjera())
                                                                                        .imputaIva(rgfacturaSave
                                                                                                        .getImputaIva())
                                                                                        .imputaIre(rgfacturaSave
                                                                                                        .getImputaIre())
                                                                                        .imputaIrpRsp(rgfacturaSave
                                                                                                        .getImputaIrpRsp())
                                                                                        .comprobanteAsociado(
                                                                                                        rgfacturaSave.getComprobanteAsociado())
                                                                                        .timbradoComprobanteAsociado(
                                                                                                        rgfacturaSave.getTimbradoComprobanteAsociado())
                                                                                        .createdBy(rgfacturaSave
                                                                                                        .getCreatedBy())
                                                                                        .createdAt(rgfacturaSave
                                                                                                        .getCreatedAt())
                                                                                        .updatedBy(rgfacturaSave
                                                                                                        .getUpdatedBy())
                                                                                        .updatedAt(rgfacturaSave
                                                                                                        .getUpdatedBy())
                                                                                        .build())
                                                        .build(),
                                        HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(
                                        MensajeResponse.builder()
                                                        .mensaje("Error al crear RgFactura")
                                                        .objeto(null)
                                                        .build(),
                                        HttpStatus.METHOD_NOT_ALLOWED);
                }
        }

        @PutMapping("rgfactura/{id}")
        public ResponseEntity<?> update(@RequestBody RgfacturaDto rgfacturaDto, @PathVariable Integer id) {

                Rgfactura rgfacturaUpdate = null;
                try {
                        if (rgfacturaService.existsById(id)) {
                                rgfacturaDto.setIdRgFactura(id);
                                rgfacturaUpdate = rgfacturaService.save(rgfacturaDto);
                                return new ResponseEntity<>(MensajeResponse.builder()
                                                .mensaje("Guardado correctamente")
                                                .objeto(RgfacturaDto.builder()
                                                                .idRgFactura(rgfacturaUpdate.getIdRgFactura())
                                                                .empresa(rgfacturaUpdate.getEmpresa())
                                                                .ruc(rgfacturaUpdate.getRuc())
                                                                .razonSocial(rgfacturaUpdate.getRazonSocial())
                                                                .mesPeriodo(rgfacturaUpdate.getMesPeriodo())
                                                                .anhoPeriodo(rgfacturaUpdate.getAnhoPeriodo())
                                                                .codigoTipoRegistro(
                                                                                rgfacturaUpdate.getCodigoTipoRegistro())
                                                                .codigoTipoComprador(rgfacturaUpdate
                                                                                .getCodigoTipoComprador())
                                                                .nroIdentificadorComprador(rgfacturaUpdate
                                                                                .getNroIdentificadorComprador())
                                                                .nombreComprador(rgfacturaUpdate.getNombreComprador())
                                                                .codigoTipoComprobante(rgfacturaUpdate
                                                                                .getCodigoTipoComprobante())
                                                                .fechaEmision(rgfacturaUpdate.getFechaEmision())
                                                                .nroTimbrado(rgfacturaUpdate.getNroTimbrado())
                                                                .nroComprobante(rgfacturaUpdate.getNroComprobante())
                                                                .montoIva10(rgfacturaUpdate.getMontoIva10())
                                                                .montoIva5(rgfacturaUpdate.getMontoIva5())
                                                                .montoExenta(rgfacturaUpdate.getMontoExenta())
                                                                .montoTotalComprobante(rgfacturaUpdate
                                                                                .getMontoTotalComprobante())
                                                                .condicionVenta(rgfacturaUpdate.getCondicionVenta())
                                                                .monedaExtranjera(rgfacturaUpdate.getMonedaExtranjera())
                                                                .imputaIva(rgfacturaUpdate.getImputaIva())
                                                                .imputaIre(rgfacturaUpdate.getImputaIre())
                                                                .imputaIrpRsp(rgfacturaUpdate.getImputaIrpRsp())
                                                                .comprobanteAsociado(rgfacturaUpdate
                                                                                .getComprobanteAsociado())
                                                                .timbradoComprobanteAsociado(rgfacturaUpdate
                                                                                .getTimbradoComprobanteAsociado())
                                                                .createdBy(rgfacturaUpdate.getCreatedBy())
                                                                .createdAt(rgfacturaUpdate.getCreatedAt())
                                                                .updatedBy(rgfacturaUpdate.getUpdatedBy())
                                                                .updatedAt(rgfacturaUpdate.getUpdatedBy())
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

        @DeleteMapping("rgfactura/{id}")
        public ResponseEntity<?> delete(@PathVariable Integer id) {

                try {
                        Rgfactura rgfacturaDelete = rgfacturaService.findById(id);
                        if (rgfacturaDelete == null) {
                                return new ResponseEntity<>(rgfacturaDelete, HttpStatus.NOT_FOUND);
                        } else {
                                rgfacturaService.delete(rgfacturaDelete);
                                return new ResponseEntity<>(rgfacturaDelete, HttpStatus.NO_CONTENT);
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
