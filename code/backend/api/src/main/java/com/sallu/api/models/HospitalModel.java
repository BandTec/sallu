package com.sallu.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_hospital")
public class HospitalModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_hospital")
    private Integer idHospital;

    @JsonProperty
    @Column(name = "hosp_nome")
    private String nome;
    @JsonProperty
    @Column(name = "hosp_local")
    private String local;

    //Relacionamento
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
    private List<EnfermeiroModel>  enfermeiro;
}
