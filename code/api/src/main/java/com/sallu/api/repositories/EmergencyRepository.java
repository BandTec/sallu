package com.sallu.api.repositories;

import com.sallu.api.entities.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyRepository extends JpaRepository<Emergency, Integer> {
}
