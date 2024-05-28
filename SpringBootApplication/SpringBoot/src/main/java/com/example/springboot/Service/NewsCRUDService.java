package com.example.springboot.Service;

import com.example.springboot.DTO.NewsDto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsCRUDService implements CRUDService<NewsDto>
{
    private  final ConcurrentHashMap <Integer, NewsDto> storage = new ConcurrentHashMap<>();
    @Override
    public NewsDto getByID(Integer id)  {
        System.out.println("Get by ID: " + id);
        return storage.get(id);
    }

    @Override
    public Collection<NewsDto> getAll() {
        System.out.println("Get all news ");
        return storage.values();
    }

    @Override
    public NewsDto create(NewsDto news) {
        System.out.println("Create");
        int nextId = (storage.isEmpty() ? 0 : storage.size()) + 1;
        news.setId(nextId);
        return storage.put(nextId, news);
    }

    @Override
    public NewsDto update(Integer id, NewsDto news) {
        System.out.println("Update: " + id);
        if (storage.containsKey(id)){
            return null;
        }
        news.setId(id);
        return storage.put(id, news);
    }

    @Override
    public NewsDto delete(Integer id) {
        System.out.println("Remove: " + id);
        return storage.remove(id);
    }
}
