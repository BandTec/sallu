package com.sallu.api.services;

import com.sallu.api.models.dto.LoginDTO;
import com.sallu.api.models.UserModel;
import com.sallu.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    public Optional<UserModel> findByEmail(LoginDTO login) {
        return this.repository.findByEmail(login.getEmail());
    }

}
