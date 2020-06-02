package com.sallu.api.entities.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sallu.api.entities.Classificacao;
import com.sallu.api.entities.Hospital;
import com.sallu.api.entities.User;
import lombok.Data;

import javax.persistence.*;
@Data
public class FichaMedicaDTO {


    // Peso
    private Double peso;

    // Altura
    private Double altura;

    // Pressão Arterial
    private Double pressao;

    // Pressão Corporal
    private Double temperaturaCorporal;

    // Sexo
    private char sexo;

    // Alergia
    private String alergia;

    // Data do Último Ciclo Menstrual
    private String dataUltCiclo;

    // Data da ficha
    private String dataFicha;

    private boolean gestante;


    private String nomeHospital;

    private ClassificacaoDTO encaminhamento;
}
