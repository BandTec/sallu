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
@Table(name = "tb_dados")
public class FichaMedica implements Serializable {

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_ficha_medica")
    private Integer idFichaMedica;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user", referencedColumnName = "pk_user")
    private User user;

    // Peso
    @JsonProperty
    @Column(name = "fl_peso")
    private Double peso;

    // Altura
    @JsonProperty
    @Column(name = "fl_altura")
    private Double altura;

    // Pressão Arterial
    @JsonProperty
    @Column(name = "fl_pressao_arterial", nullable = false)
    private Double pressao;

    // Pressão Corporal
    @JsonProperty
    @Column(name = "fl_temperatura_corporal", nullable = false)
    private Double temperaturaCorporal;

    // Sexo
    @JsonProperty
    @Column(name = "nm_sexo", length = 1, nullable = false)
    private String sexo;

    // Alergia
    @JsonProperty
    @Column(name = "nm_alergia", nullable = false)
    private String alergia;

    // Data do Último Ciclo Menstrual
    @JsonProperty
    @Column(name = "data_ult_ciclo", nullable = false)
    private String dataUltCiclo;

    // Data da ficha
    @JsonProperty
    @Column(name = "data_ficha", nullable = false)
    private String dataFicha;

    @JsonProperty
    @Column(name = "gestante", nullable = false)
    private boolean gestante;

    @ManyToOne(cascade = CascadeType.ALL)
    private Hospital hospital;

    @ManyToOne(cascade = CascadeType.ALL)
    private Paciente paciente;

}

