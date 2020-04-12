package com.sallu.api.repository;

import com.sallu.api.models.dto.EspecialistaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialistaRepository extends JpaRepository<EspecialistaDTO,Integer> {
}
