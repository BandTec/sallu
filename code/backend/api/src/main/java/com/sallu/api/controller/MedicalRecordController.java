package com.sallu.api.controller;

import com.sallu.api.models.MedicalRecordModel;
import com.sallu.api.services.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("medical_records")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService service;

    @GetMapping
    public ResponseEntity<List<MedicalRecordModel>> getMedicalRecords() {
        List<MedicalRecordModel> medicalRecords = service.selectAll();

        return medicalRecords.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(medicalRecords);
    }

    @PostMapping
    public ResponseEntity<Void> createMedicalRecord(@RequestBody @Valid MedicalRecordModel medicalRecord) {
        service.insert(medicalRecord);
        return ResponseEntity.created(null).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateMedicalRecord(@RequestBody @Valid MedicalRecordModel medicalRecord) {
        service.update(medicalRecord);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
