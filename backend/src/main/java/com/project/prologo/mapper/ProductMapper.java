package com.project.prologo.mapper;

import com.project.prologo.entities.CategoryEntity;
import com.project.prologo.entities.ProductEntity;
import com.project.prologo.models.CategoryDto;
import com.project.prologo.models.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductMapper {

    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "price", target = "price")
    @Mapping(expression = "java(buildCategoryWitId(dto.getCategory()))", target = "category")
    public abstract ProductEntity fromDtoToEntity(ProductDto dto);

    public CategoryEntity buildCategoryWitId(CategoryDto dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(dto.getId());
        categoryEntity.setName(dto.getName());
        return categoryEntity;
    }

}