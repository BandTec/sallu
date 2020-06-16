package com.sallu.api.services;
import com.sallu.api.entities.Classificacao;
import com.sallu.api.entities.Endereco;
import com.sallu.api.entities.Hospital;
import com.sallu.api.entities.dto.HospitalDTO;
import com.sallu.api.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HospitalService {
    @Autowired
    private HospitalRepository repository;

    public void insert(HospitalDTO hospital) {
        Endereco endereco = new Endereco(hospital.getEndereco());
        Hospital newHospital = Hospital.builder()
                .nomeHospital(hospital.getNomeHospital())
                .cnpjHospital(hospital.getCnpjHospital())
                .emailHospital(hospital.getEmailHospital())
                .telefoneHospital(hospital.getTelefoneHospital())
                .endereco(endereco)
                .build();
        this.repository.save(newHospital);
    }
}
