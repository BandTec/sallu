package com.sallu.api.models.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "tb_Enfermeiro")
public class EnfermeiroDTO {

    @Id
    @GeneratedValue
    private Integer idEnfermeiro;
    private String email;
    private String senha;

    //Chave estrangeira tbHospital
    @ManyToOne
    private HospitalDTO fkHospital;


    public Integer getIdEnfermeiro() {
        return idEnfermeiro;
    }

    public void setIdEnfermeiro(Integer idEnfermeiro) {
        this.idEnfermeiro = idEnfermeiro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
