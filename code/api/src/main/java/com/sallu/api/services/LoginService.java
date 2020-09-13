package com.sallu.api.services;

import com.sallu.api.dtos.LoginDTO;
import com.sallu.api.entities.User;
import com.sallu.api.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UsersRepository repository;

    public Optional<User> findByEmail(LoginDTO login) {
        return this.repository.findByEmail(login.getEmail());

    }

}
