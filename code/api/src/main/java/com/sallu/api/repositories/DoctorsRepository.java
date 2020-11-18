package com.sallu.api.repositories;
import com.sallu.api.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DoctorsRepository extends JpaRepository <Doctors, Integer> {
    @Query("select u from Doctors u where u.hospital.id=?1")
    List<Doctors> findAll (Integer idHospital);
}