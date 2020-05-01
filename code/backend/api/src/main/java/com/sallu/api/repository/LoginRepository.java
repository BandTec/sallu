package com.sallu.api.repository;

import com.sallu.api.models.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
}
