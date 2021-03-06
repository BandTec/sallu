package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospitals")
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonProperty
    @Column(name = "name", unique = true)
    private String name;

    @JsonProperty
    @Column(name="cnpj")
    private String cnpj;

    @JsonProperty
    @Column(name = "telephone")
    private String telephone;

    @JsonProperty
    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    //Relacionamento
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
//    private List<EnfermeiroModel>  enfermeiro;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
//    private List<PacienteModel>  paciente;

}
