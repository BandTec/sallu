package com.sallu.api.services;

import com.sallu.api.entities.FichaMedica;
import com.sallu.api.repository.FichaMedicaRepository;
import com.sallu.api.services.exceptions.MedicalRecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private FichaMedicaRepository repository;

    public List<FichaMedica> selectAll() {
        return this.repository.findAll();
    }

    public void insert(FichaMedica medicalRecord) {

        FichaMedica newMedicalRecord = FichaMedica.builder()
                .peso(medicalRecord.getPeso())
                .altura(medicalRecord.getAltura())
                .pressao(medicalRecord.getPressao())
                .temperaturaCorporal(medicalRecord.getTemperaturaCorporal())
                .sexo(medicalRecord.getSexo())
                .alergia(medicalRecord.getAlergia())
                .dataUltCiclo(medicalRecord.getDataUltCiclo())
                .dataFicha(medicalRecord.getDataFicha())
                .gestante(medicalRecord.isGestante())
                .build();

        this.repository.save(newMedicalRecord);
    }

    public void update(FichaMedica medicalRecord) {
        this.repository.findById(medicalRecord.getIdFichaMedica())
                .map(selectedMedicalRecord -> {
                    selectedMedicalRecord.setPeso(medicalRecord.getPeso());
                    selectedMedicalRecord.setAltura(medicalRecord.getAltura());
                    selectedMedicalRecord.setPressao(medicalRecord.getPressao());
                    selectedMedicalRecord.setTemperaturaCorporal(medicalRecord.getTemperaturaCorporal());
                    selectedMedicalRecord.setSexo(medicalRecord.getSexo());
                    selectedMedicalRecord.setAlergia(medicalRecord.getAlergia());
                    selectedMedicalRecord.setDataUltCiclo(medicalRecord.getDataUltCiclo());
                    selectedMedicalRecord.setDataFicha(medicalRecord.getDataFicha());
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
