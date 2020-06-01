package com.sallu.api.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class RegisterDTO {

    @NotBlank(message = "Por favor, digite o seu nome completo")
    private String name;

    @NotBlank(message = "Por favor, digite o seu e-mail")
    @Email(message = "Por favor, insira um e-mail válido")
    private String email;

    @NotBlank(message = "Por favor, insira uma senha")
    @Size(min = 8, max = 32, message = "Sua senha deve conter entre 8 à 32 caracteres")
    private String password;
}
