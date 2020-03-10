package com.sallu.api.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "paciente")
public class UserDomain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @JsonProperty
    private String name;

    @JsonProperty
    private Date dataNascimento;

    @Email
    @NotBlank
    @JsonProperty
    @Column(unique = true)
    private String email;

    @NotBlank
    @JsonProperty
    private String password;

    @JsonProperty
    private Integer consultas;

    public UserDomain() {
    }

    public UserDomain(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.consultas = 0;
    }

    public Integer getId() {
        return id;
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
