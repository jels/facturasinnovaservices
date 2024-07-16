package com.innova.facturas.facturasinnovaservices.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "cotizacion")
public class Cotizacion implements Serializable {

    @Id
    @Column(name = "id_cotizacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCotizacion;

    @ManyToOne // (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ajuste", nullable = false)
    private Ajuste ajuste;

    @Column(name = "compra")
    private Double compra;

    @Column(name = "venta")
    private Double venta;

    @Column(name = "status")
    private String status;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

}
