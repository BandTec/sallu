package com.sallu.api.entities.dto;
import lombok.Data;

@Data
public class EnderecoDTO {
    private String cep;
    private String endereco;
    private String bairro;
    private String logradouro;
    private String cidade;
    private String estado;
}
