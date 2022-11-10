package com.example.springbootmustachebbs3.controller;

import com.example.springbootmustachebbs3.domain.Article;
import com.example.springbootmustachebbs3.domain.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.springbootmustachebbs3.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public String index() {
        return "redirect:/articles/list";
    }

    @GetMapping("/list")
    public String getList(Model model) {
        List<Article> articles = articleRepository.findAll();

        model.addAttribute("articles", articles);
        return "list";
    }

    @GetMapping("/new")
    public String createPage() {
        return "new";
    }

    @PostMapping("")
    public String add(ArticleDto articleDto) {
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> byId = articleRepository.findById(id);
        if (!byId.isEmpty()) {
            model.addAttribute("article", byId.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isEmpty()) {
            model.addAttribute("article", optionalArticle.get());
            return "edit";
        } else {
            model.addAttribute("message", String.format("%d가 없습니다.", id));
            return "error";
        }
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, ArticleDto articleDto, Model model) {
        log.info("title:{} content:{}", articleDto.getTitle(), articleDto.getContent());
        Article save = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", save);
        return String.format("redirect:/articles/%d", save.getId());
    }


}
