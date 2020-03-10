package com.sallu.api.controller;

import com.sallu.api.domain.UserDomain;
import com.sallu.api.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public final class UserController {

    @Autowired
    private PacienteService service;


    private List<UserDomain> userDomainList = new ArrayList<UserDomain>();
    private UserDomain userDomainLogged;

    @GetMapping
    public ResponseEntity<List<UserDomain>> usuarios(){
        return ResponseEntity.ok(this.service.selectAll());
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody UserDomain userDomain) {

        if (userDomain.getName() == null || userDomain.getEmail() == null || userDomain.getPassword() == null) {
            return ResponseEntity.badRequest().body("Preencha todos os campos");
        }

        this.service.insert(userDomain);
        return ResponseEntity.ok("Usuário cadastrado");

//        for (UserDomain userDomain : userDomainList) {
//            if (newUserDomain.getEmail().equals(userDomain.getEmail())) {
//                return "Usuário já cadastrado";
//            }
//        }
//
//        userDomainList.add(newUserDomain);
//        return "Usuário cadastrado";

    }

}
