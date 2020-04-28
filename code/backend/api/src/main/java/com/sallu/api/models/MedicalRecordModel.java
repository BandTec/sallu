package com.sallu.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_dados")
public class MedicalRecordModel implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_dados")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user", referencedColumnName = "pk_user")
    private UserModel user;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<EspecialistaModel> especialista;

    // Peso
    @JsonProperty
    @Column(name = "fl_weight")
    private Double weight;

    // Altura
    @JsonProperty
    @Column(name = "fl_height")
    private Double height;

    // Pressão Arterial
    @JsonProperty
    @Column(name = "fl_blood_pressure")
    private Double bloodPressure;

    // Pressão Corporal
    @JsonProperty
    @Column(name = "fl_body_pressure")
    private Double bodyPressure;

    // Sexo
    @JsonProperty
    @Column(name = "nm_sex", length = 1, nullable = false)
    private String sex;

    // Alergia
    @JsonProperty
    @Column(name = "nm_alergy", nullable = false)
    private String allergy;

    // Data do Último Ciclo Menstrual
    @JsonProperty
    @Column(name = "dt_last_cycle", nullable = false)
    private String dateLastCycle;

}

