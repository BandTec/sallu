package com.sallu.api.entities;
import lombok.Data;

@Data
public class Encerramento {

    private String registro;
    private int qtdRegistros;

    public Encerramento(String registro, int qtdRegistros) {
        this.registro = registro;
        this.qtdRegistros = qtdRegistros;
    }
}
