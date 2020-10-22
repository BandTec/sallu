package com.sallu.api.repositories;

import com.sallu.api.entities.Hospital;
import com.sallu.api.models.HospitalSimples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HospitalsRepository extends JpaRepository<Hospital, Integer> {

    //Optional <Hospital> medicalRecordHospital = hospitalsRepository.findById(medicalRecord.getHospitalId());
    Optional <Hospital> findById(Integer id);


    @Query("select new com.sallu.api.models.HospitalSimples(h) from Hospital h")
    List<HospitalSimples> findAllSimples();
}
