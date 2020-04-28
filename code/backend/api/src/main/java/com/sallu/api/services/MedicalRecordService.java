package com.sallu.api.services;

import com.sallu.api.models.MedicalRecordModel;
import com.sallu.api.repository.MedicalRecordRepository;
import com.sallu.api.services.exceptions.MedicalRecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository repository;

    public List<MedicalRecordModel> selectAll() {
        return this.repository.findAll();
    }

    public void insert(MedicalRecordModel medicalRecord) {

        MedicalRecordModel newMedicalRecord = MedicalRecordModel.builder()
                .weight(medicalRecord.getWeight())
                .height(medicalRecord.getHeight())
                .bloodPressure(medicalRecord.getBloodPressure())
                .bodyPressure(medicalRecord.getBodyPressure())
                .sex(medicalRecord.getSex())
                .allergy(medicalRecord.getAllergy())
                .dateLastCycle(medicalRecord.getDateLastCycle())
                .build();

        this.repository.save(newMedicalRecord);
    }

    public void update(MedicalRecordModel medicalRecord) {
        this.repository.findById(medicalRecord.getId())
                .map(selectedMedicalRecord -> {
                    selectedMedicalRecord.setWeight(medicalRecord.getWeight());
                    selectedMedicalRecord.setHeight(medicalRecord.getHeight());
                    selectedMedicalRecord.setBloodPressure(medicalRecord.getBloodPressure());
                    selectedMedicalRecord.setBodyPressure(medicalRecord.getBodyPressure());
                    selectedMedicalRecord.setSex(medicalRecord.getSex());
                    selectedMedicalRecord.setAllergy(medicalRecord.getAllergy());
                    selectedMedicalRecord.setDateLastCycle(medicalRecord.getDateLastCycle());
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
