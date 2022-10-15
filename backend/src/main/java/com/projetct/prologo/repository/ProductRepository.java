package com.projetct.prologo.repository;

import com.projetct.prologo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT obj FROM Product obj WHERE obj.name LIKE :name")
    Page<Product> findProductsLikedName(String name, Pageable pageable);

}
