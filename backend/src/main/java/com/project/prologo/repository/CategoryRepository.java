package com.project.prologo.repository;

import com.project.prologo.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query("SELECT obj FROM CategoryEntity obj WHERE obj.name LIKE :name ")
    Page<CategoryEntity> findCategoryLikedName(String name, Pageable pageable);

}
