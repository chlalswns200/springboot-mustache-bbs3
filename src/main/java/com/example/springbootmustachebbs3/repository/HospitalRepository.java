package com.example.springbootmustachebbs3.repository;

import com.example.springbootmustachebbs3.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);

    List<Hospital> findByRoadNameAddressContaining(String roadName);

    List<Hospital> findByTotalNumberOfBedsBetween(Integer num1,Integer num2);

}
