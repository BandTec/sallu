package com.sallu.api.controller;

import com.sallu.api.entities.Classificacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    AtendimentoController atendimento = new AtendimentoController();

    @GetMapping
    public ResponseEntity<List<Classificacao>> atendimento() {



    }

}
