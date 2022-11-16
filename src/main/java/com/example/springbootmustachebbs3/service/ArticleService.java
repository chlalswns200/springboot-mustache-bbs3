package com.example.springbootmustachebbs3.service;

import com.example.springbootmustachebbs3.domain.Article;
import com.example.springbootmustachebbs3.domain.dto.ArticleDto;
import com.example.springbootmustachebbs3.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticleById(Long id) {
        Optional<Article> byId = articleRepository.findById(id);
        Article article = byId.get();
        ArticleDto articleDto = new ArticleDto(article.getId(), article.getTitle(), article.getContent());
        return articleDto;
    }
}
