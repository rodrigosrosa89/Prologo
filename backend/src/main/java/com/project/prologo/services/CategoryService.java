package com.project.prologo.services;

import com.project.prologo.entities.CategoryEntity;
import com.project.prologo.mapper.CategoryMapper;
import com.project.prologo.models.CategoryDto;
import com.project.prologo.repository.CategoryRepository;
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

    public Page<CategoryEntity> findsCategories(String name, Pageable pageable) {
        if (!Strings.isBlank(name)) {
            return repository.findCategoryLikedName(name, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    public CategoryEntity findCategoryById(Long id) {
        Optional<CategoryEntity> optionalCategory = repository.findById(id);
        return optionalCategory.orElse(null);
    }

    public void save(CategoryDto categoryDto) {
        repository.save(CategoryMapper.INSTANCE.fromDtoToEntity(categoryDto));
    }

    public void delete(Long idCategory) {
        repository.deleteById(idCategory);
    }

}
