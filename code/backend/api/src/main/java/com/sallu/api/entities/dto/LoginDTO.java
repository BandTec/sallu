package com.sallu.api.entities.dto;
import java.io.Serializable;
public class LoginDTO implements Serializable {

    private String email;
    private String password;

    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
