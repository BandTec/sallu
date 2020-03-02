package com.sallu.api.controller;

import com.sallu.api.domain.User;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController
{
    private User userActual;

    @PostMapping("/register/{nome}/{email}/{password}/{confirmPassword}")
    public void registerUser(@PathVariable("nome")String nome, @PathVariable("email") String email, @PathVariable("password")String password, @PathVariable("confirmPassword")String confirmPassword)
    {

    }

}
