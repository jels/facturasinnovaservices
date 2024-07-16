package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.CotizacionDao;
import com.innova.facturas.facturasinnovaservices.model.dto.CotizacionDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Cotizacion;
import com.innova.facturas.facturasinnovaservices.services.CotizacionService;

@Service
public class CotizacionServiceImpl implements CotizacionService {

    @Autowired
    private CotizacionDao cotizacionDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Cotizacion> getAllCotizaciones() {
        return (List) cotizacionDao.findAll();
    }

    @Transactional
    @Override
    public Cotizacion save(CotizacionDto cotizacionDto) {
        Cotizacion cotizacion = Cotizacion.builder()
                .idCotizacion(cotizacionDto.getIdCotizacion())
                .ajuste(cotizacionDto.getAjuste())
                .compra(cotizacionDto.getCompra())
                .venta(cotizacionDto.getVenta())
                .status(cotizacionDto.getStatus())
                .createdBy(cotizacionDto.getCreatedBy())
                .createdAt(cotizacionDto.getCreatedAt())
                .updatedBy(cotizacionDto.getUpdatedBy())
                .updatedAt(cotizacionDto.getUpdatedAt()).build();

        return cotizacionDao.save(cotizacion);
    }

    @Transactional(readOnly = true)
    @Override
    public Cotizacion findById(Integer id) {
        return cotizacionDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cotizacion cotizacion) {
        cotizacionDao.delete(cotizacion);
    }

    @Override
    public boolean existsById(Integer id) {
        return cotizacionDao.existsById(id);
    }

}
