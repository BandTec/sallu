package com.sallu.api.repository;
import com.sallu.api.models.MedicalRecordModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecordModel, Integer> {
}
