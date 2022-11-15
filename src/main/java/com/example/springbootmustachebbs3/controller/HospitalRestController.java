package com.example.springbootmustachebbs3.controller;

import com.example.springbootmustachebbs3.domain.Hospital;
import com.example.springbootmustachebbs3.domain.dto.HospitalResponse;
import com.example.springbootmustachebbs3.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {


    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id) {
        HospitalResponse hospital = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospital); // Return은 DTO로
    }
}
