package com.sallu.api.controller;
import com.sallu.api.entities.User;
import com.sallu.api.repository.UserRepository;
import com.sallu.api.services.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geraTxt")
public class GeneratorController {

    @Autowired
    private GeneratorService geradorService;
    @Autowired
    private UserRepository repository;

    @GetMapping
    public String gerarArquivo() {
        User usuario = repository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
        geradorService.gerarArquivo(usuario);
        return "Foi!";
    }
}
