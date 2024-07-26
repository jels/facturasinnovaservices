package com.innova.facturas.facturasinnovaservices.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.DetalleAjuste;

@Repository
public interface DetalleAjusteDao extends JpaRepository<DetalleAjuste, Integer> {

    @Query("from DetalleAjuste d where d.ajuste.idAjuste= :idAjuste")
    List<DetalleAjuste> findDetalleByIdAjuste(Integer idAjuste);

}
