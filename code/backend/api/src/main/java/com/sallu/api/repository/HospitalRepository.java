package com.sallu.api.repository;
import com.sallu.api.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
