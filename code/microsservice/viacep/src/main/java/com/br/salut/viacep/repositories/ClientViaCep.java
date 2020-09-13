package com.br.salut.viacep.repositories;

import com.br.salut.viacep.models.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viacep", url = "https://viacep.com.br")
public interface ClientViaCep
{
    @GetMapping("ws/{cep}/json")
    Cep getCep(@PathVariable String cep);
}
