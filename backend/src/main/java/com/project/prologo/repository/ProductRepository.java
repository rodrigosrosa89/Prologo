package com.project.prologo.repository;

import com.project.prologo.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT obj FROM ProductEntity obj WHERE obj.name LIKE :name")
    Page<ProductEntity> findProductsLikedName(String name, Pageable pageable);

}
