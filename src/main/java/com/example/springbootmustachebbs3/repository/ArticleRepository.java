package com.example.springbootmustachebbs3.repository;

import com.example.springbootmustachebbs3.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long>{
}
