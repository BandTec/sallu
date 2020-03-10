package com.sallu.api.services;

import com.sallu.api.domain.UserDomain;
import com.sallu.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public void insert(UserDomain user){
        this.repository.save(user);
    }

    public List<UserDomain> selectAll(){
        return this.repository.findAll();
    }
}
