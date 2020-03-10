package com.sallu.api.domain;

import java.io.Serializable;

public class LoginDomain implements Serializable {

    private String email;

    private String password;

    public LoginDomain() {
    }

    public LoginDomain(String email, String password) {
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
