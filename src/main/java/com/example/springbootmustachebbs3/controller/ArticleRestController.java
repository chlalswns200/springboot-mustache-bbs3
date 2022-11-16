package com.example.springbootmustachebbs3.controller;

import com.example.springbootmustachebbs3.domain.Article;
import com.example.springbootmustachebbs3.domain.dto.ArticleDto;
import com.example.springbootmustachebbs3.repository.ArticleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleRepository articleRepository;

    public ArticleRestController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id) {
        Optional<Article> byId = articleRepository.findById(id);
        Article article = byId.get();
        ArticleDto articleDto = new ArticleDto(article.getId(), article.getTitle(), article.getContent());
        return ResponseEntity.ok().body(articleDto);
    }
}
