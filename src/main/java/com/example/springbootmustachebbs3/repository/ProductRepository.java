package com.example.springbootmustachebbs3.repository;

import com.example.springbootmustachebbs3.domain.Product;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ProductRepository extends JpaRepositoryImplementation<Product,Long> {

}
