package com.projetct.prologo.controllers;

import com.projetct.prologo.entities.Product;
import com.projetct.prologo.services.ProductService;
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
    public Page<Product> findProducts(@RequestParam(value = "name", defaultValue = "") String name,
                                      Pageable pageable) {
        return service.findsProducts(name, pageable);
    }

    @GetMapping(value = "/{id}")
    public Product findProducts(@PathVariable Long id) {
        return service.findProductById(id);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        service.save(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        service.save(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        service.delete(product);
    }
}