package com.example.springbootmustachebbs3.repository;

import com.example.springbootmustachebbs3.domain.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HospitalRepositoryTest {
    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        for (var hospital :
                hospitals) {
            System.out.println(hospital.getHospitalName() + " " +hospital.getRoadNameAddress() + " " +hospital.getBusinessTypeName());
        }
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByRoadNameAddressIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining("송파구");
        for (var hospital :
                hospitals) {
            System.out.println(hospital.getHospitalName() + " " +hospital.getRoadNameAddress() + " " +hospital.getBusinessTypeName());
        }
    }

    @Test
    @DisplayName("병상수")
    void bedCount() {
        List<Hospital> byTotalNumberOfBedsBetween = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountDesc(10, 19);

        for (Hospital hospital : byTotalNumberOfBedsBetween) {
            System.out.println(hospital.getHospitalName() + " " + hospital.getPatientRoomCount());
        }
    }
}

