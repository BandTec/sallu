package com.sallu.api.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenDTO implements Serializable {
    private String login;
    private String token;
    private String nome;
    private Integer id;

}
