package com.sallu.api.repository;

import com.sallu.api.models.dto.DadosDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosRepository extends JpaRepository<DadosDTO,Integer> {
}
