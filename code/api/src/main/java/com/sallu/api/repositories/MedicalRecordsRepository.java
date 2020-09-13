package com.sallu.api.repositories;
import com.sallu.api.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecord, Integer> {

}
