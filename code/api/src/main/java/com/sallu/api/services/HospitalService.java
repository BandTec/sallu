package com.sallu.api.services;
import com.sallu.api.dtos.AddressDTO;
import com.sallu.api.entities.Address;
import com.sallu.api.entities.Hospital;
import com.sallu.api.dtos.HospitalDTO;
import com.sallu.api.repositories.HospitalsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HospitalService {
    @Autowired
    private HospitalsRepository repository;

    public void insert(HospitalDTO hospital) {
        Address address = new Address(hospital.getAddress());
        Hospital newHospital = Hospital.builder()
                .name(hospital.getName())
                .cnpj(hospital.getCnpj())
                .email(hospital.getEmail())
                .telephone(hospital.getTelephone())
                .address(address)
                .build();
        this.repository.save(newHospital);
    }
}