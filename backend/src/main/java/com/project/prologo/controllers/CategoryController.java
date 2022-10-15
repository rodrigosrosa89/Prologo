package com.project.prologo.controllers;

import com.project.prologo.entities.CategoryEntity;
import com.project.prologo.models.CategoryDto;
import com.project.prologo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public Page<CategoryEntity> findsCategories(@RequestParam(value = "name", defaultValue = "") String name,
                                                Pageable pageable) {
        return service.findsCategories(name, pageable);
    }

    @GetMapping(value = "/{id}")
    public CategoryEntity getCategoryById(@PathVariable Long id) {
        return service.findCategoryById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryDto categoryDto) {
        service.save(categoryDto);
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryDto categoryDto) {
        service.save(categoryDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.delete(id);
    }

}
