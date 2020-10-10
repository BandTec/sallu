package com.sallu.api.dtos;
import lombok.Data;
@Data
public class AddressDTO {
    private String cep;
    private String endereco;
    private String bairro;
    private String logradouro;
    private String cidade;
    private String estado;
    //private String numero;
}