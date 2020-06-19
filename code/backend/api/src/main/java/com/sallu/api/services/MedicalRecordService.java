package com.sallu.api.services;

import com.sallu.api.entities.Classificacao;
import com.sallu.api.entities.FichaMedica;
import com.sallu.api.entities.Hospital;
import com.sallu.api.entities.User;
import com.sallu.api.entities.dto.FichaMedicaDTO;
import com.sallu.api.repository.FichaMedicaRepository;
import com.sallu.api.repository.HospitalRepository;
import com.sallu.api.repository.UserRepository;
import com.sallu.api.services.exceptions.MedicalRecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class MedicalRecordService {

    @Autowired
    private FichaMedicaRepository repository;

    @Autowired
    private UserRepository repositoryU;

    @Autowired
    private HospitalRepository repositoryH;


    public List<FichaMedica> selectAll() {
        return this.repository.findAll();
    }

    public void insert(FichaMedicaDTO medicalRecord) {
        Classificacao classificacao = new Classificacao(medicalRecord.getEncaminhamento());
        log.info(classificacao.toString());

        FichaMedica newMedicalRecord = FichaMedica.builder()
                .peso(medicalRecord.getPeso())
                .altura(medicalRecord.getAltura())
                .pressao(medicalRecord.getPressao())
                .temperaturaCorporal(medicalRecord.getTemperaturaCorporal())
                .sexo(medicalRecord.getSexo())
                .alergia(medicalRecord.getAlergia())
                .dataUltCiclo(medicalRecord.getDataUltCiclo())
                .dataFicha(LocalDate.now().toString())
                .gestante(medicalRecord.isGestante())
                .user(repositoryU.findByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).get())
                .hospital(repositoryH.findBynomeHospital(medicalRecord.getNomeHospital()))
                .classificacao(classificacao)
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
