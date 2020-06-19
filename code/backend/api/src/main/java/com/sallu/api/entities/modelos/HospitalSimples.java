package com.sallu.api.entities.modelos;

import com.sallu.api.entities.Hospital;

public class HospitalSimples {
    private Integer id;
    private String nome;

    public HospitalSimples(Hospital hospital) {
        this.id = hospital.getIdHospital();
        this.nome = hospital.getNomeHospital();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
