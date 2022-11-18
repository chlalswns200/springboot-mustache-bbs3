package com.example.springbootmustachebbs3.controller;

import com.example.springbootmustachebbs3.domain.Hospital;
import com.example.springbootmustachebbs3.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {

    private final HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("")
    public String list(@RequestParam String keyword,Pageable pageable, Model model) {

        log.info("keyword:{}",keyword);
        Page<Hospital> byRoadNameAddressContaining = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);

        model.addAttribute("hospitals",byRoadNameAddressContaining);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "hospital/list";
    }
}
