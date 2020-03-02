package com.sallu.api.controller;

import com.sallu.api.domain.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController
{
    private User userActual;

    @PostMapping("/{nome}/{email}/{password}/{confirmPassword}")
    public void registerUser(@PathVariable("nome")String nome, @PathVariable("email") String email, @PathVariable("password")String password, @PathVariable("confirmPassword")String confirmPassword)
    {
        if(nome.equals(null) || email.equals(null) || password.equals(null) || confirmPassword.equals(null))
        {
            System.out.println("Preencha todos os campos");
        }
        else if(password != confirmPassword)
        {
            System.out.println("As senhas devem ser iguais");
        }
        else{
            userActual = new User(nome, email, password, confirmPassword);
            System.out.println("Usuário cadastrado, bem vindo!");
        }

    }

}
