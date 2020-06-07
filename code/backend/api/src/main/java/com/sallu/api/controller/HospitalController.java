package com.sallu.api.controller;

import com.sallu.api.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalRepository repository;

    @GetMapping
    public ResponseEntity consultarSimples() {
        List hospital = repository.findAllSimples();
        return hospital.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(hospital);
    }
}