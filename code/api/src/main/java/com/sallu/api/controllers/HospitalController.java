//package com.sallu.api.controllers;
//import com.sallu.api.dtos.HospitalDTO;
//import com.sallu.api.repositories.HospitalsRepository;
//import com.sallu.api.services.HospitalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/hospital")
//public class HospitalController {
//    @Autowired
//    private HospitalsRepository repository;
//
//    @Autowired
//    private HospitalService service;
//
//    @GetMapping
//    public ResponseEntity consultarSimples() {
//        List hospital = repository.findAllSimples();
//        return hospital.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(hospital);
//    }
//
//    @PostMapping("/cad")
//    public ResponseEntity<Void> cadastrarHospital(@RequestBody @Valid HospitalDTO hospital) {
//        service.insert(hospital);
//        return ResponseEntity.created(null).build();
//    }
//}