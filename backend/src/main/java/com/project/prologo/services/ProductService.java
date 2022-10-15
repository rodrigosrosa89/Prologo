package com.project.prologo.services;

import com.project.prologo.entities.ProductEntity;
import com.project.prologo.mapper.CategoryMapper;
import com.project.prologo.mapper.ProductMapper;
import com.project.prologo.models.ProductDto;
import com.project.prologo.repository.ProductRepository;
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

    public Page<ProductEntity> findsProducts(String name, Pageable pageable) {
        if (!Strings.isBlank(name)) {
            return repository.findProductsLikedName(name, pageable);
        } else {
            return repository.findAll(pageable);
        }

    }

    public ProductEntity findProductById(Long id) {
        Optional<ProductEntity> optionalProduct = repository.findById(id);
        return optionalProduct.orElse(null);
    }

    public void save(ProductDto dto) {
        repository.save(ProductMapper.INSTANCE.fromDtoToEntity(dto));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
