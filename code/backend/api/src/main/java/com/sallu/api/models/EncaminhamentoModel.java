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
@Table(name= "tb_encaminhamento")
public class EncaminhamentoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_encaminhamento")
    private Integer idEncaminhamento;

    @JsonProperty
    @Column(name = "tipo_especialista", length = 128, nullable = false)
    private String tipoEspecialista;

    @JsonProperty
    @Column(name = "cor_classificacao", length = 40, nullable = false)
    private String corClassificada;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ficha_medica", referencedColumnName = "pk_dados")
    private MedicalRecordModel fkFichaMedica;

}
