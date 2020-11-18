package com.sallu.api.controllers;

import com.sallu.api.entities.Doctors;
import com.sallu.api.entities.Scheduling;
import com.sallu.api.repositories.SchedulingRepository;
import com.sallu.api.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("scheduling")
public class SchedulingController {
    @Autowired
    private SchedulingService service;

    @GetMapping("{idUser}")
    public ResponseEntity<List<Scheduling>> getUserId(@PathVariable("idUser") Integer idUser) {
        List<Scheduling> medicalRecords = service.getId(idUser);
        return medicalRecords.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(medicalRecords);
    }
}
