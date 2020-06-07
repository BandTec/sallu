package com.sallu.api.entities.modelos;

import com.sallu.api.entities.Hospital;

public class HospitalSimples {

    private String nome;

    public HospitalSimples(String nome) {
        this.nome = nome;
    }

    public HospitalSimples(Hospital hospital) {

        this.nome = hospital.getNomeHospital();
    }

    public String getNome() {
        return nome;
    }
}
