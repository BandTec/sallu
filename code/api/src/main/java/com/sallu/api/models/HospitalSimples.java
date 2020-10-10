package com.sallu.api.models;

import com.sallu.api.entities.Hospital;

public class HospitalSimples {
    private Integer id;
    private String nome;

    public HospitalSimples(Hospital hospital) {
        this.id = hospital.getId();
        this.nome = hospital.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
