package com.sallu.api.controllers;

import com.sallu.api.entities.Doctors;
import com.sallu.api.entities.User;
import com.sallu.api.services.DoctorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("doctors")
public class DoctorsController {

    @Autowired
    private DoctorsService service;

    @GetMapping
    public ResponseEntity<List<Doctors>> getDoctors() {
        List<Doctors> doctors = service.selectAll();

        return doctors.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(service.selectAll());
    }

    @GetMapping("{idHospital}")
    public ResponseEntity <List<Doctors>> getDoctorId(@PathVariable("idHospital") Integer idHospital) {
        List<Doctors> medicalRecords = service.getId(idHospital);
        return medicalRecords.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(medicalRecords);
    }
}
