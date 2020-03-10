package com.sallu.api.controller;

import com.sallu.api.domain.User;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/user")
public class UserController
{
    private List<User> userList = new ArrayList<User>();
    protected User userLogged;

    @GetMapping
    public User getUser() {
        return userLogged;
    }

    @PostMapping("/{nome}/{email}/{password}")
    public String registerUser(
            @PathVariable("nome")String nome,
            @PathVariable("email") String email,
            @PathVariable("password")String password
    ) {
        if (nome == null || email == null || password == null) {
            return "Preencha todos os campos";
        }
        User newUser = new User(nome, email, password);

        for (User user : userList) {
            if (newUser.getEmail().equals(user.getEmail())) {
                return "Usuário já cadastrado";
            }
        }

        userList.add(newUser);
        return "Usuário cadastrado";

    }

    @PostMapping("/login/{email}/{password}")
    public String loginUser(
            @PathVariable("email") String email,
            @PathVariable("password") String password
    ) {

        if (userLogged == null) {
            return "Usuário já logado";
        }
        for (User user: userList) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    userLogged = user;
                    return "Usuário logado com sucesso!";
                }
                return "Senha inválida";
            }
        }

        return "Usuário não registrado";
    }

}
