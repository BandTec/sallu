package com.sallu.api.services;

import com.sallu.api.dtos.ReferralDTO;
import com.sallu.api.entities.Hospital;
import com.sallu.api.entities.MedicalRecord;
import com.sallu.api.entities.Referral;
import com.sallu.api.dtos.MedicalRecordDTO;
import com.sallu.api.repositories.MedicalRecordsRepository;
import com.sallu.api.repositories.HospitalsRepository;
import com.sallu.api.repositories.UsersRepository;
import com.sallu.api.services.exceptions.MedicalRecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordsRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HospitalsRepository hospitalsRepository;


    public List<MedicalRecord> selectAll() {
        return this.repository.findAll();
    }

    public void insert(MedicalRecordDTO medicalRecord) {

        Referral referral = new Referral(medicalRecord.getReferral());
        Optional <Hospital> medicalRecordHospital = hospitalsRepository.findById(medicalRecord.getHospitalId());

        MedicalRecord newMedicalRecord = MedicalRecord.builder()
                .weight(medicalRecord.getWeight())
                .height(medicalRecord.getHeight())
                .bloodPressure(medicalRecord.getBloodPressure())
                .bodyTemperature(medicalRecord.getBodyTemperature())
                .allergy(medicalRecord.getAllergy())
                .lastCycle(medicalRecord.getLastCycle())
                .isPregnant(medicalRecord.isPregnant())
                .createdAt(LocalDate.now().toString())
                .user(usersRepository.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get())
                //.hospital(medicalRecordHospital)
                .referral(referral)
                .build();

        this.repository.save(newMedicalRecord);
    }

    public void update(MedicalRecord medicalRecord) {
        this.repository.findById(medicalRecord.getId())
                .map(selectedMedicalRecord -> {
                    selectedMedicalRecord.setWeight(medicalRecord.getWeight());
                    selectedMedicalRecord.setHeight(medicalRecord.getHeight());
                    selectedMedicalRecord.setBloodPressure(medicalRecord.getBloodPressure());
                    selectedMedicalRecord.setBodyTemperature(medicalRecord.getBodyTemperature());
                    selectedMedicalRecord.setAllergy(medicalRecord.getAllergy());
                    selectedMedicalRecord.setLastCycle(medicalRecord.getLastCycle());
//                    selectedMedicalRecord.setCreatedAt(medicalRecord.getCreatedAt());
                    return this.repository.save(selectedMedicalRecord);
                })
                .orElseThrow(
                        () -> new MedicalRecordNotFoundException("Usuário não encontrado.")
                );
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
