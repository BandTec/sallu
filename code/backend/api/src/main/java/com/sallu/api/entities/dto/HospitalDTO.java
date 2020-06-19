package com.sallu.api.entities.dto;
import com.sallu.api.entities.Endereco;
import lombok.Data;
@Data
public class HospitalDTO {
    private Integer idHospital;
    private String nomeHospital;
    private String cnpjHospital;
    private String telefoneHospital;
    private String emailHospital;

    //Relacionamento
    private EnderecoDTO endereco;
}
