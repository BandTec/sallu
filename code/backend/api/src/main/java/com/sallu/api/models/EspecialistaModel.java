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
@Table(name= "tb_especialista")
public class EspecialistaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_especialista")
    private Integer idTbEspecialista;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_dados", referencedColumnName = "pk_dados")
//    private MedicalRecordModel medicalRecord;

    @JsonProperty
    @Column(name = "tipo_especialista", length = 128, nullable = false)
    private String tipoEspecialista;

    @JsonProperty
    @Column(name = "cor_classificacao", length = 40, nullable = false)
    private String corClassificada;

//    Chave estrangeira tbHospital
//    @ManyToOne
//    private  fkHospital;
}
