package com.projetct.prologo.controllers;

import com.projetct.prologo.entities.Category;
import com.projetct.prologo.services.CategoryService;
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
    public Page<Category> findsCategories(@RequestParam(value = "name", defaultValue = "") String name,
                                          Pageable pageable) {
        return service.findsCategories(name, pageable);
    }

    @GetMapping(value = "/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return service.findCategoryById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        service.save(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody Category category) {
        service.save(category);
    }

    @DeleteMapping
    public void deleteCategory(@RequestBody Category category) {
        service.delete(category);
    }

}
