package com.example.springbootmustachebbs3.service;

import com.example.springbootmustachebbs3.domain.Hospital;
import com.example.springbootmustachebbs3.domain.dto.HospitalResponse;
import com.example.springbootmustachebbs3.repository.HospitalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


class HospitalServiceTest {

    private HospitalRepository hospitalRepository = Mockito.mock(HospitalRepository.class);

    private HospitalService hospitalService;

    @BeforeEach
    void init() {
        hospitalService = new HospitalService(hospitalRepository);
    }

    @Test
    @DisplayName("13 - 영업중")
    void status() {

        Hospital hosptal1 = Hospital.builder()
                .id(4)
                .businessStatusCode(13)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hosptal1));

        HospitalResponse hospital = hospitalService.getHospital(4);

        assertEquals("영업중",hospital.getBusinessStatusName());

    }

    @Test
    @DisplayName("3 - 폐업")
    void status2() {

        Hospital hosptal1 = Hospital.builder()
                .id(71857)
                .businessStatusCode(3)
                .build();

        Mockito.when(hospitalRepository.findById(any()))
                .thenReturn(Optional.of(hosptal1));

        HospitalResponse hospital = hospitalService.getHospital(71857);

        assertEquals("폐업",hospital.getBusinessStatusName());

    }



}