package com.sallu.api.controller;

import com.sallu.api.domain.LoginDomain;
import com.sallu.api.domain.UserDomain;
import com.sallu.api.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService service;
    private UserDomain loggedUser;

    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDomain user) {

        List<UserDomain> logados = this.service.findEmailAndSenha(user);

        if (logados.isEmpty()) {
            return ResponseEntity.status(404).body("Usuário não existe");
        }

        loggedUser = logados.get(0);
        return ResponseEntity.ok("Usuário logado");


    }

    @GetMapping("/loggedUser")
    public UserDomain getLoggedUser() {
        return loggedUser;
    }

    @GetMapping("logout")
    public void logout() {
        loggedUser = null;
    }


}
