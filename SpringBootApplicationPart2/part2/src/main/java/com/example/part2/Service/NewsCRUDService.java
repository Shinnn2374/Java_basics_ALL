package com.example.part2.Service;

import com.example.part2.Dto.NewsDto;
import com.example.part2.entity.News;
import com.example.part2.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class NewsCRUDService implements CRUDService<NewsDto>
{
    private final NewsRepository newsRepository;


    @Override
    public NewsDto getByID(Integer id) {
        return mapToDto(newsRepository.findById(id).orElseThrow());
    }

    @Override
    public Collection<NewsDto> getAll() {
        return newsRepository.findAll().stream()
                .map(NewsCRUDService::mapToDto)
                .toList();
    }

    @Override
    public void create(NewsDto newsDto) {
        News news = mapToEntity(newsDto);
        Long newsId = newsDto.getId();
        News news1 = newsRepository.findById(newsId.intValue()).orElseThrow();
        news.setId(newsId);
        newsRepository.save(news1);
    }

    @Override
    public void update(Integer id, NewsDto newsDto) {
        System.out.println("Update");
        News news = mapToEntity(newsDto);
        Long newsId = newsDto.getId();
        News news1 = newsRepository.findById(newsId.intValue()).orElseThrow();
        news.setId(newsId);
        newsRepository.save(news1);
    }

    @Override
    public void delete(Integer id) {
        newsRepository.deleteById(id);
    }

    public static News mapToEntity(NewsDto newsDto){
        News news = new News();
        news.setId(newsDto.getId());
        news.setTitle(newsDto.getTitle());
        news.setText(newsDto.getText());
        news.setDate(newsDto.getDate());
        return news;
    }

    public static NewsDto mapToDto(News news){
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setTitle(news.getTitle());
        newsDto.setText(news.getText());
        newsDto.setDate(news.getDate());
        return newsDto;
    }
}
