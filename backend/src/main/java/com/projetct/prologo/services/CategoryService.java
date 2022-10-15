package com.projetct.prologo.services;

import com.projetct.prologo.entities.Category;
import com.projetct.prologo.repository.CategoryRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Page<Category> findsCategories(String name, Pageable pageable) {
        if (!Strings.isBlank(name)) {
            return repository.findCategoryLikedName(name, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    public Category findCategoryById(Long id) {
        Optional<Category> optionalCategory = repository.findById(id);
        return optionalCategory.orElse(null);
    }

    public void save(Category category) {
        repository.save(category);
    }

    public void delete(Category category) {
        repository.delete(category);
    }

}
