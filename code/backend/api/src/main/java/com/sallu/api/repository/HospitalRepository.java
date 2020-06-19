package com.sallu.api.repository;

import com.sallu.api.entities.Hospital;
import com.sallu.api.entities.modelos.HospitalSimples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

    Hospital findBynomeHospital(String nome);

    @Query("select new com.sallu.api.entities.modelos.HospitalSimples(h) from Hospital h")
    List<HospitalSimples> findAllSimples();
}
