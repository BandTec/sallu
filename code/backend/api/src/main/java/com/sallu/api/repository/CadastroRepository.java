package com.sallu.api.repository;
import com.sallu.api.models.dto.CadastroDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<CadastroDTO,Integer> {

}
