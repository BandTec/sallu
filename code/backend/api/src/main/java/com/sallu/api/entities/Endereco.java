package com.sallu.api.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sallu.api.entities.dto.EnderecoDTO;
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

    @JsonProperty
    @Column(name = "cidade", length = 45)
    private String cidade;

    @JsonProperty
    @Column(name = "estado", length = 45)
    private String estado;

    public Endereco(EnderecoDTO enderecoDTO) {
        this.cep = enderecoDTO.getCep();
        this.endereco = enderecoDTO.getEndereco();
        this.bairro = enderecoDTO.getBairro();
        this.numero = enderecoDTO.getLogradouro();
        this.cidade = enderecoDTO.getCidade();
        this.estado = enderecoDTO.getEstado();
    }
}
