package com.example.springboot.Service;

import com.example.springboot.DTO.NewsDto;

import java.util.Collection;

public interface CRUDService<T>
{
    T getByID(Integer  id);
    Collection<T> getAll();
    NewsDto create(T news);
    NewsDto update(Integer id, T news);
    NewsDto delete(Integer id);
}
