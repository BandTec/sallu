package com.sallu.api.models;
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
@Table(name = "tb_enfermeiro")
public class EnfermeiroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_enfermeiro")
    private Integer idEnfermeiro;

    @JsonProperty
    @Column(name = "enf_email")
    private String email;

    @JsonProperty
    @Column(name = "enf_senha")
    private String senha;

    //Chave estrangeira tbHospital
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_hospital", referencedColumnName = "pk_hospital")
    private HospitalModel fkHospital;
}
