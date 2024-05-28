package com.example.part2.Service;

import com.example.part2.Dto.CategoryDto;
import com.example.part2.entity.Category;
import com.example.part2.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public abstract class CategoryCRUDService implements CRUDService<CategoryDto>{

    private CategoryRepository  repository;



    @Override
    public CategoryDto getByID(Integer id) {
        return mapToDto(repository.findById(id).orElseThrow());
    }

    @Override
    public Collection<CategoryDto> getAll() {
        return  repository.findAll().stream()
                .map(CategoryCRUDService::mapToDto)
                .toList();
    }

    public static Category mapToEntity(CategoryDto categoryDto){
        Category category = new Category();
        category.setId(category.getId());
        category.setTitle(category.getTitle());
        return category;
    }
    public static CategoryDto mapToDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        return categoryDto;
    }
}
