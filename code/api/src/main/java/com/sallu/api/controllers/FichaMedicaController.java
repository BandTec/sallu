package com.sallu.api.controllers;

import com.sallu.api.entities.MedicalRecord;
import com.sallu.api.dtos.MedicalRecordDTO;
import com.sallu.api.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("medical_records")
public class FichaMedicaController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping
    public ResponseEntity<List<MedicalRecord>> getMedicalRecords() {
        List<MedicalRecord> medicalRecords = service.selectAll();
        return medicalRecords.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(medicalRecords);
    }

    @PostMapping
    public ResponseEntity<Void> createMedicalRecord(@RequestBody @Valid MedicalRecordDTO fichaMedica) {
        service.insert(fichaMedica);
        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateMedicalRecord(@RequestBody @Valid MedicalRecord medicalRecord) {
        service.update(medicalRecord);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable("id") Integer idFichaMedica) {
        service.delete(idFichaMedica);
        return ResponseEntity.noContent().build();
    }
}
