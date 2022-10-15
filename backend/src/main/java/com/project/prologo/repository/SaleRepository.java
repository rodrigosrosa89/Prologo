package com.project.prologo.repository;

import com.project.prologo.entities.SaleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {

    @Query("SELECT obj FROM SaleEntity obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
    Page<SaleEntity> findSales(LocalDate min, LocalDate max, Pageable pageable);

}
