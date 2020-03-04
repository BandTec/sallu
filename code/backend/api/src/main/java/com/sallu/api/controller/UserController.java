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
    private List<User> UserList = new ArrayList<User>();

    @PostMapping("/{nome}/{email}/{password}")
    public void registerUser(@PathVariable("nome")String nome, @PathVariable("email") String email, @PathVariable("password")String password)
    {
        if(nome.equals(null) || email.equals(null) || password.equals(null))
        {
            System.out.println("Preencha todos os campos");
            User newUser = new User(nome, email, password);

            UserList.add(newUser);
        }

    }

    @PostMapping("/login/{email}/{password}")
    public String loginUser(@PathVariable("email") String email, @PathVariable("password")String password)
    {
        Stream<User> matchUser = UserList.stream().filter(user -> user.getEmail().equals(email));

        if (matchUser.count() < 1) {
            return "Usuário ou senha incorretos 1";
        }

        matchUser.limit(1).map(user -> {

            if (!user.getPassword().equals(password)) {
                return "Usuário ou senha incorretos 2";
            }

            return user;
        });

        return "Usuário logado";
    }

}
