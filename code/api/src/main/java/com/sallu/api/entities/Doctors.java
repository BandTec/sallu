package com.sallu.api.entities;
import javax.persistence.*;

@Entity
public class Doctors {
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    private String area;
    private String email;
    @ManyToOne
    private Hospital hospital;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getEmail() {
        return email;
    }

    public Hospital getHospital() {
        return hospital;
    }
}