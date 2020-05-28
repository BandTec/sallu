package com.sallu.api.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_endereco")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_enderecol")
    private Integer idEndereco;

    @JsonProperty
    @Column(name = "cep")
    private String cep;

    @JsonProperty
    @Column(name="endereco")
    private String endereco;

    @JsonProperty
    @Column(name = "bairro")
    private String bairro;

    @JsonProperty
    @Column(name = "numero")
    private String numero;

}
