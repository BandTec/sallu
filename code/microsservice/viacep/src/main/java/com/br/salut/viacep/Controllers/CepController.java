package com.br.salut.viacep.Controllers;

import com.br.salut.viacep.models.Cep;
import com.br.salut.viacep.repositories.ClientViaCep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class CepController
{
    @Autowired
    private ClientViaCep clientViaCep;

    @CrossOrigin
    @GetMapping("/cep/{cep}")
    public ResponseEntity consultarCep(@PathVariable String cep)
    {
        Cep cepEncontrados = clientViaCep.getCep(cep);

        if(cepEncontrados != null)
        {
            return ResponseEntity.ok(cepEncontrados);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
