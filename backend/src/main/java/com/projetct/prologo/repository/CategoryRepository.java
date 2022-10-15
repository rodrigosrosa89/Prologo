package com.projetct.prologo.repository;

import com.projetct.prologo.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT obj FROM Category obj WHERE obj.name LIKE :name ")
    Page<Category> findCategoryLikedName(String name, Pageable pageable);

}
