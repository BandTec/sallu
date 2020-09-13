package com.sallu.api.controllers;

import com.sallu.api.clients.ClientViaCep;
import com.sallu.api.models.Cep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class CepController
{
    @Autowired
    private ClientViaCep clientViaCep;

    @GetMapping("/cep/{cep}")
    public ResponseEntity consultarCep(@PathVariable String cep)
    {
        Cep cepEncontrados = clientViaCep.getCep(cep);

        if(cepEncontrados != null)
        {
            return ResponseEntity.ok(cepEncontrados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
