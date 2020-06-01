package com.sallu.api.entities;
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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_endereco")
    private Integer idEndereco;

    @JsonProperty
    @Column(name = "cep", length = 45, nullable = false)
    private String cep;

    @JsonProperty
    @Column(name = "endereco", length = 45)
    private String endereco;

    @JsonProperty
    @Column(name = "bairro", length = 45)
    private String bairro;

    @JsonProperty
    @Column(name = "numero", length = 45)
    private String numero;

}
