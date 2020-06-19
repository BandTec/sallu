package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sallu.api.entities.dto.ClassificacaoDTO;
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
public class Classificacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_classificacoes")
    private Integer idClassificacoes;

    @Column(name = "cor_classificacao", length = 45, nullable = false)
    private String corClassificada;

    @Column(name = "n_atendimento", length = 45, nullable = false)
    private String nAtendimento;

    public Classificacao(ClassificacaoDTO classificacaoDTO) {
        this.corClassificada = classificacaoDTO.getCorClassificada();
        this.nAtendimento = classificacaoDTO.getNumeroAtendimento();
    }
}
