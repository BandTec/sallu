package com.sallu.api.repository;
import com.sallu.api.models.HospitalModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface HospitalRepository extends JpaRepository<HospitalModel,Integer> {
}
