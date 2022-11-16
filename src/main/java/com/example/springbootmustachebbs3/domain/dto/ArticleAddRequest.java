package com.example.springbootmustachebbs3.domain.dto;

import com.example.springbootmustachebbs3.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleAddRequest {

    private String title;
    private String content;


    public Article toEntity(ArticleAddRequest dto) {

        Article article = Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return article;
    }
}
