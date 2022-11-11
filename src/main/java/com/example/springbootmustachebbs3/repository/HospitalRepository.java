package com.example.springbootmustachebbs3.repository;

import com.example.springbootmustachebbs3.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
