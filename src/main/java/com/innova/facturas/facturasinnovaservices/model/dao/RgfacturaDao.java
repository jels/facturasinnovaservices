package com.innova.facturas.facturasinnovaservices.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innova.facturas.facturasinnovaservices.model.entity.Rgfactura;

@Repository
public interface RgfacturaDao extends JpaRepository<Rgfactura, Integer> {

    @Query("from Rgfactura r order by r.ruc, r.anhoPeriodo, r.mesPeriodo asc")
    List<Rgfactura> findAllOrderASC();

    @Query("from Rgfactura r where r.ruc= :ruc order by r.anhoPeriodo, r.mesPeriodo asc")
    List<Rgfactura> findAllByRuc(Integer ruc);

    @Query("FROM Rgfactura r GROUP BY r.ruc, r.mesPeriodo, r.anhoPeriodo ORDER BY r.ruc, r.anhoPeriodo, r.mesPeriodo ASC")
    List<Rgfactura> listRg90();

}
