package com.sallu.api.services;

import com.sallu.api.entities.dto.LoginDTO;
import com.sallu.api.entities.User;
import com.sallu.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findByEmail(LoginDTO login) {
        return this.repository.findByEmail(login.getEmail());
    }

}
