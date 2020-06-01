package com.sallu.api.repository;
import com.sallu.api.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

}
