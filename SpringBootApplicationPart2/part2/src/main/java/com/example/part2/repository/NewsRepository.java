package com.example.part2.repository;

import com.example.part2.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository <News, Integer>
{
}
