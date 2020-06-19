package com.sallu.api.controller;
import com.sallu.api.entities.dto.FichaMedicaDTO;
import com.sallu.api.entities.dto.HospitalDTO;
import com.sallu.api.repository.HospitalRepository;
import com.sallu.api.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalRepository repository;

    @Autowired
    private HospitalService service;

    @GetMapping
    public ResponseEntity consultarSimples() {
        List hospital = repository.findAllSimples();
        return hospital.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(hospital);
    }

    @PostMapping("/cad")
    public ResponseEntity<Void> cadastrarHospital(@RequestBody @Valid HospitalDTO hospital) {
        service.insert(hospital);
        return ResponseEntity.created(null).build();
    }
}