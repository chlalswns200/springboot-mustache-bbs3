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


    public Article toEntity() {

        Article article = Article.builder()
                .title(this.getTitle())
                .content(this.getContent())
                .build();
        return article;
    }
}
