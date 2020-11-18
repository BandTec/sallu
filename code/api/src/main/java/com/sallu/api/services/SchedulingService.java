package com.sallu.api.services;

import com.sallu.api.entities.Doctors;
import com.sallu.api.entities.Scheduling;
import com.sallu.api.repositories.SchedulingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository repository;

    public List<Scheduling> getId(Integer idUser) {
        return this.repository.findAll(idUser);
    }
}
