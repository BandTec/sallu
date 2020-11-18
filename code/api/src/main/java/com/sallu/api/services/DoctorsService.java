package com.sallu.api.services;

import com.sallu.api.entities.Doctors;
import com.sallu.api.entities.User;
import com.sallu.api.repositories.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    @Autowired
    private DoctorsRepository repository;

    public List<Doctors> selectAll(){
        return this.repository.findAll();
    }

    public List<Doctors> getId(Integer idHospital) {
        return this.repository.findAll(idHospital);
    }
}
