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
    @Column(name = "hospital_nome")
    private String nomeHospital;

    @JsonProperty
    @Column(name="hospital_cnpj")
    private String cnpjHospital;

    @JsonProperty
    @Column(name = "hospital_telefone")
    private String telefoneHospital;

    @JsonProperty
    @Column(name = "hospital_email")
    private String emailHospital;

    //Relacionamento
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
//    private List<EnfermeiroModel>  enfermeiro;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
//    private List<PacienteModel>  paciente;
}
