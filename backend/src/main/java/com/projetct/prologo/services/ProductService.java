package com.projetct.prologo.services;

import com.projetct.prologo.entities.Product;
import com.projetct.prologo.repository.ProductRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Page<Product> findsProducts(String name, Pageable pageable) {
        if (!Strings.isBlank(name)) {
            return repository.findProductsLikedName(name, pageable);
        } else {
            return repository.findAll(pageable);
        }

    }

    public Product findProductById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void save(Product product) {
        repository.save(product);
    }

    public void delete(Product product) {
        repository.delete(product);
    }

}
