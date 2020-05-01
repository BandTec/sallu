package com.sallu.api.repository;
import com.sallu.api.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel,Integer> {

}
