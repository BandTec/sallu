package com.sallu.api.services;

import com.sallu.api.domain.LoginDomain;
import com.sallu.api.domain.UserDomain;
import com.sallu.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private PacienteRepository repository;

    public List<UserDomain> findEmailAndSenha(LoginDomain login){
        return this.repository.findEmailAndSenha(login.getEmail(), login.getPassword());
    }

}
