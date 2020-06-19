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
@Table(name = "tb_hospital")
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_hospital")
    private Integer idHospital;

    @JsonProperty
    @Column(name = "hospital_nome", unique = true)
    private String nomeHospital;

    @JsonProperty
    @Column(name="hospital_cnpj")
    private String cnpjHospital;

    @JsonProperty
    @Column(name = "hospital_telefone")
    private String telefoneHospital;

    @JsonProperty
    @Column(name = "email_hospital")
    private String emailHospital;

    //Relacionamento
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;


    //Relacionamento
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
//    private List<EnfermeiroModel>  enfermeiro;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkHospital")
//    private List<PacienteModel>  paciente;

}
