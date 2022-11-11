package com.example.springbootmustachebbs3.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name ="nation_wide_hospitals")
public class Hospital {

    @Id
    private Integer id;

    @Column(name = "road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;

}
