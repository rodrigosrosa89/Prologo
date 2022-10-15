package com.project.prologo.controllers;

import com.project.prologo.entities.ProductEntity;
import com.project.prologo.models.ProductDto;
import com.project.prologo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public Page<ProductEntity> findProducts(@RequestParam(value = "name", defaultValue = "") String name,
                                            Pageable pageable) {
        return service.findsProducts(name, pageable);
    }

    @GetMapping(value = "/{id}")
    public ProductEntity findProducts(@PathVariable Long id) {
        return service.findProductById(id);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto dto) {
        service.save(dto);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto dto) {
        service.save(dto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.delete(id);
    }
}