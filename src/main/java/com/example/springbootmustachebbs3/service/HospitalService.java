package com.example.springbootmustachebbs3.service;

import com.example.springbootmustachebbs3.domain.Hospital;
import com.example.springbootmustachebbs3.domain.dto.HospitalResponse;
import com.example.springbootmustachebbs3.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        Hospital hospital = optHospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital);
        if (hospital.getBusinessStatusCode() == 13) {
            hospitalResponse.setBusinessStatusName("영업중");
        } else if (hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else {
            hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
        }

        return hospitalResponse;
    }

}
