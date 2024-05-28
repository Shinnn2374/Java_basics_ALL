package com.example.springboot.DTO;

import java.time.Instant;

public class NewsDto
{
    private  Integer id;
    private String title;
    private String text;
    private Instant date;

    public NewsDto(Integer id, String title, String text, Instant date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = Instant.now();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
