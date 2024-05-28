package com.example.part2.Controller;

import com.example.part2.Dto.NewsDto;
import com.example.part2.Service.NewsCRUDService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class NewsController
{
    private final NewsCRUDService newsService;

    public NewsController(NewsCRUDService newsService){
        this.newsService = newsService;
    }

    @GetMapping(path = "/api/news/{id}")
    public NewsDto getById (@PathVariable Integer id){
        return newsService.getByID(id);
    }

    @GetMapping(path = "/api/news")
    public Collection<NewsDto> getAll (){
        return newsService.getAll();
    }

    @PostMapping(path = "/api/news")
    public NewsDto create  (@RequestBody NewsDto newsDto){
        newsService.create(newsDto);
        return  newsDto;
    }

    @PutMapping(path = "/api/news")
    public NewsDto update (@PathVariable Integer id, @RequestBody NewsDto newsDto){
        newsService.update(id, newsDto);
        return newsDto;
    }

    @DeleteMapping(path = "/api/news/{id}")
    public void deleteById (@PathVariable Integer id){
        newsService.delete(id);
    }
}