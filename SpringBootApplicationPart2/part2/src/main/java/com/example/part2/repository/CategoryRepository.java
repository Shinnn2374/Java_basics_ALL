package com.example.part2.repository;

import com.example.part2.Dto.CategoryDto;
import com.example.part2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category,Integer>
{
}
