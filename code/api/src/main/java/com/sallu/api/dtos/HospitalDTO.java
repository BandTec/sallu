package com.sallu.api.dtos;
import lombok.Data;
@Data
public class HospitalDTO {
    private Integer id;
    private String name;
    private String cnpj;
    private String telephone;
    private String email;
    //private String number;

    //Relacionamento
    private AddressDTO address;
}
