package com.project.prologo.mapper;

import com.project.prologo.entities.CategoryEntity;
import com.project.prologo.models.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CategoryMapper {

    public static final CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "name", target = "name")
    public abstract CategoryEntity fromDtoToEntity(CategoryDto dto);

}
