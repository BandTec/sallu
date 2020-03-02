package com.sallu.api.controller;

import com.sallu.api.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController
{
    private User userActual;

    @GetMapping("/{email}/{password}")
    public void loginUser(@PathVariable("email") String email, @PathVariable("password")String password)
    {
        if(email.equals(userActual.getEmail())  && password.equals(userActual.getPassword()))
        {
            System.out.println("Bem vindo " + userActual.getName() + "!");
        }else if(email != userActual.getEmail()){
            System.out.println("Email não cadastrado");
        }else if(password != userActual.getPassword()){
            System.out.println("Senha incorreta");
        }
    }
}
