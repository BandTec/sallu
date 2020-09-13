package com.sallu.api.models;

import com.sallu.api.entities.Hospital;

public class HospitalSimples {
    private Integer id;
    private String name;

    public HospitalSimples(Hospital hospital) {
        this.id = hospital.getId();
        this.name = hospital.getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
