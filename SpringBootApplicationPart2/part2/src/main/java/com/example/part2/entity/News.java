package com.example.part2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;


@Entity
@Getter
@Setter
@Table(name = "News")
public class News
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private Instant date;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category  categoryId;
}
