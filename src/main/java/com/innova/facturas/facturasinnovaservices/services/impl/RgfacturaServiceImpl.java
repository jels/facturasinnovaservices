package com.innova.facturas.facturasinnovaservices.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innova.facturas.facturasinnovaservices.model.dao.RgfacturaDao;
import com.innova.facturas.facturasinnovaservices.model.dto.RgfacturaDto;
import com.innova.facturas.facturasinnovaservices.model.entity.Rgfactura;
import com.innova.facturas.facturasinnovaservices.services.RgfacturaService;

@Service
public class RgfacturaServiceImpl implements RgfacturaService {

    @Autowired
    private RgfacturaDao rgfacturaDao;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public List<Rgfactura> getAllRgfacturas() {
        return (List) rgfacturaDao.findAll();
    }

    @Transactional
    @Override
    public Rgfactura save(RgfacturaDto rgfacturaDto) {

        Rgfactura rgfactura = Rgfactura.builder()
                .idRgFactura(rgfacturaDto.getIdRgFactura())
                .empresa(rgfacturaDto.getEmpresa())
                .mesPeriodo(rgfacturaDto.getMesPeriodo())
                .anhoPeriodo(rgfacturaDto.getAnhoPeriodo())
                .codigoTipoRegistro(rgfacturaDto.getCodigoTipoRegistro())
                .codigoTipoComprador(rgfacturaDto.getCodigoTipoComprador())
                .nroIdentificadorComprador(rgfacturaDto.getNroIdentificadorComprador())
                .nombreComprador(rgfacturaDto.getNombreComprador())
                .codigoTipoComprobante(rgfacturaDto.getCodigoTipoComprobante())
                .fechaEmision(rgfacturaDto.getFechaEmision())
                .nroTimbrado(rgfacturaDto.getNroTimbrado())
                .nroComprobante(rgfacturaDto.getNroComprobante())
                .montoIva10(rgfacturaDto.getMontoIva10())
                .montoIva5(rgfacturaDto.getMontoIva5())
                .montoExenta(rgfacturaDto.getMontoExenta())
                .montoTotalComprobante(rgfacturaDto.getMontoTotalComprobante())
                .condicionVenta(rgfacturaDto.getCondicionVenta())
                .monedaExtranjera(rgfacturaDto.getMonedaExtranjera())
                .imputaIva(rgfacturaDto.getImputaIva())
                .imputaIre(rgfacturaDto.getImputaIre())
                .imputaIrpRsp(rgfacturaDto.getImputaIrpRsp())
                .comprobanteAsociado(rgfacturaDto.getComprobanteAsociado())
                .timbradoComprobanteAsociado(rgfacturaDto.getTimbradoComprobanteAsociado())
                .createdBy(rgfacturaDto.getCreatedBy())
                .createdAt(rgfacturaDto.getCreatedAt())
                .updatedBy(rgfacturaDto.getUpdatedBy())
                .updatedAt(rgfacturaDto.getUpdatedBy())
                .build();
        return rgfacturaDao.save(rgfactura);
    }

    @Transactional(readOnly = true)
    @Override
    public Rgfactura findById(Integer id) {
        return rgfacturaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Rgfactura rgfactura) {
        rgfacturaDao.delete(rgfactura);
    }

    @Override
    public boolean existsById(Integer id) {
        return rgfacturaDao.existsById(id);
    }

}
