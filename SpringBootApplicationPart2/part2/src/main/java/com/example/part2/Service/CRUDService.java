package com.example.part2.Service;

import com.example.part2.Dto.NewsDto;
import com.example.part2.entity.News;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface CRUDService<T>
{
    T getByID(Integer  id);
    Collection<T> getAll();
    void  create(T news);
    void update(Integer id, T news);
    void delete(Integer id);
}
