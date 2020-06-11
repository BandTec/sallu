package com.sallu.api.repository;
import com.sallu.api.entities.FichaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Integer> {

}
