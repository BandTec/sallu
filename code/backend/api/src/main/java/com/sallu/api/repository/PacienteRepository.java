package com.sallu.api.repository;

import com.sallu.api.domain.LoginDomain;
import com.sallu.api.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<UserDomain, Integer> {

    @Query("select u from UserDomain u where u.email = :email and u.password = :password")
    List<UserDomain> findEmailAndSenha(String email, String password);

}
