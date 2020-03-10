package com.sallu.api.domain;


import java.util.Date;

public class User
{
    private String name;
    private Date dataNascimento;

    private String email;
    private String password;

    private Integer consultas;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.consultas = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getConsultas() {
        return consultas;
    }

    public void setConsultas(Integer consultas) {
        this.consultas = consultas;
    }
}
