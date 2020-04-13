package com.sallu.api.models.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "tb_Hopital")
public class HospitalDTO {

    @Id
    @GeneratedValue
    private Integer idHospital;
    private String nome;
    private String local;

    //Relacionamento
    @OneToMany(mappedBy = "fkHospital")
    private Set<EnfermeiroDTO> fkHospital = new HashSet<>();

    public Integer getId() {
        return idHospital;
    }

    public void setId(Integer id) {
        this.idHospital = idHospital;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
