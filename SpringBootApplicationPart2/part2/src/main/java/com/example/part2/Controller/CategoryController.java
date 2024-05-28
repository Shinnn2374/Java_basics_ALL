package com.example.part2.Controller;

import com.example.part2.Dto.CategoryDto;
import com.example.part2.Service.CategoryCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

public class CategoryController
{
    private final  CategoryCRUDService categoryService;

    public CategoryController(CategoryCRUDService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(path = "/api/news/{id}")
    public CategoryDto getById (@PathVariable Integer id){
        return categoryService.getByID(id);
    }

    @GetMapping(path = "/api/news")
    public Collection<CategoryDto> getAll (){
        return categoryService.getAll();
    }

    @PostMapping(path = "/api/news")
    public CategoryDto create  (@RequestBody CategoryDto categoryDto){
        categoryService.create(categoryDto);
        return categoryDto;
    }

    @PutMapping(path = "/api/news")
    public CategoryDto update (@PathVariable Integer id, @RequestBody CategoryDto categoryDto){
        categoryService.update(id, categoryDto);
        return categoryDto;
    }

    @DeleteMapping(path = "/api/news/{id}")
    public void deleteById (@PathVariable Integer id){
        categoryService.delete(id);
    }
}
