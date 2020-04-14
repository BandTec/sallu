package com.sallu.api.repository;
import com.sallu.api.models.EnfermeiroModel;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EnfermeiroRepository  extends JpaRepository<EnfermeiroModel, Integer> {
}
