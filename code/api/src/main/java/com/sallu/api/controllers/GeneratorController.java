package com.sallu.api.controllers;
import com.sallu.api.entities.User;
import com.sallu.api.repositories.UsersRepository;
import com.sallu.api.services.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

@RestController
@RequestMapping("/geraTxt")
public class GeneratorController {

    @Autowired
    private GeneratorService geradorService;
    @Autowired
    private UsersRepository repository;

    @GetMapping
    public ResponseEntity gerarArquivo() throws IOException {
        User usuario = repository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
        LocalDate today= LocalDate.now();
        geradorService.gerarArquivo(usuario, today);
        File file = new File(today+".txt");

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export.txt");
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}

