package com.sallu.api.dtos;

import com.sallu.api.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class TokenDTO implements Serializable {
//    private String login;
    private User user;
    private String token;
//    private String nome;
//    private Integer id;

}
