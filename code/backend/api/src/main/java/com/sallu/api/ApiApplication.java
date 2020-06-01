package com.sallu.api;

import com.sallu.api.filaAtendimentos.AtendimentoAmarelo;
import com.sallu.api.filaAtendimentos.AtendimentoVerde;
import com.sallu.api.filaAtendimentos.AtendimentoVermelho;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		
	}

}
