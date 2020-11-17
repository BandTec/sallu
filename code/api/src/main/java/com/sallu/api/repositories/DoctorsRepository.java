package com.sallu.api.repositories;
import com.sallu.api.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository <Doctors, Integer> {
}
