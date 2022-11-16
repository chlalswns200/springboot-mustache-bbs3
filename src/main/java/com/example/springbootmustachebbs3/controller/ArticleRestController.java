package com.example.springbootmustachebbs3.controller;

import com.example.springbootmustachebbs3.domain.Article;
import com.example.springbootmustachebbs3.domain.dto.ArticleAddRequest;
import com.example.springbootmustachebbs3.domain.dto.ArticleAddResponse;
import com.example.springbootmustachebbs3.domain.dto.ArticleDto;
import com.example.springbootmustachebbs3.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id) {
        ArticleDto articleById = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleById);
    }

    @PostMapping("/new")
    public ResponseEntity<ArticleAddResponse> join(@RequestBody ArticleAddRequest dto) {
        ArticleAddResponse add = articleService.add(dto);
        return ResponseEntity.ok().body(add);
    }
}
