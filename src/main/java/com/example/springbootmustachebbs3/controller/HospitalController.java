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
    public String index() {
        return "redirect:/hospital/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Hospital> all = hospitalRepository.findAll();
        List<Hospital> test = new ArrayList<>();
        int i =0;
        for (Hospital hospital : all) {
            test.add(hospital);
            i++;
            if(i==10) break;
        }
        model.addAttribute("hospitals",test);
        return "hospital/list";
    }

    @GetMapping("/listV2")
    public String listV2(Model model, @PageableDefault(size = 20, direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Hospital> all = hospitalRepository.findAll(pageable);

        model.addAttribute("hospitals",all);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospital/list";
    }

}
