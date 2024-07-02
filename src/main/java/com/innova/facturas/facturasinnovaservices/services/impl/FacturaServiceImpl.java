package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.FacturaDao;
import com.innova.facturas.facturasinnovaservices.model.dto.FacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Factura;
import com.innova.facturas.facturasinnovaservices.services.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDao facturaDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Factura> getAllFacturas() {
        return (List) facturaDao.findAll();
    }

    @Transactional
    @Override
    public Factura save(FacturaDto facturaDto) {

        Factura factura = Factura.builder()
                .idFactura(facturaDto.getIdFactura())
                .tipoFactura(facturaDto.getTipoFactura())
                .timbradoFactura(facturaDto.getTimbradoFactura())
                .cdcFactura(facturaDto.getCdcFactura())
                .codigoControlFactura(facturaDto.getCodigoControlFactura())
                .numeroFactura(facturaDto.getNumeroFactura())
                .rucEmisorFactura(facturaDto.getRucEmisorFactura())
                .razonSocialEmisorFactura(facturaDto.getRazonSocialEmisorFactura())
                .rucReceptorFactura(facturaDto.getRucReceptorFactura())
                .razonSocialReceptorFactura(facturaDto.getRazonSocialReceptorFactura())
                .condicionVentaFactura(facturaDto.getCondicionVentaFactura())
                .fechaInicioVigenciaFactura(facturaDto.getFechaInicioVigenciaFactura())
                .fechaFinVigenciaFactura(facturaDto.getFechaFinVigenciaFactura())
                .fechaEmisionFactura(facturaDto.getFechaEmisionFactura())
                .montoTotalFactura(facturaDto.getMontoTotalFactura())
                .montoTotalIvaFactura(facturaDto.getMontoTotalIvaFactura())
                .monto5Factura(facturaDto.getMonto5Factura())
                .monto10Factura(facturaDto.getMonto10Factura())
                .excentaFactura(facturaDto.getExcentaFactura())
                .statusFactura(facturaDto.getStatusFactura())
                .createdBy(facturaDto.getCreatedBy())
                .createdAt(facturaDto.getCreatedAt())
                .updatedAt(facturaDto.getUpdatedAt())
                .updatedBy(facturaDto.getUpdatedBy())
                .build();
        return facturaDao.save(factura);
    }

    @Transactional(readOnly = true)
    @Override
    public Factura findById(Integer id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Factura factura) {
        facturaDao.delete(factura);
    }

    @Override
    public boolean existsById(Integer id) {
        return facturaDao.existsById(id);
    }

}
