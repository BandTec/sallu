package com.sallu.api.controllers;

import com.sallu.api.entities.User;
import com.sallu.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UsersService service;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.selectAll();

        return users.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(service.selectAll());
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid User user) {
        service.insert(user);
        return ResponseEntity.status(201).build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody @Valid User user) {
        service.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{idUser}")
    public ResponseEntity <Optional<User>> getUserId(@PathVariable("idUser") Integer idUser) {
        Optional<User> medicalRecords = service.getId(idUser);
        return !medicalRecords.isPresent()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(medicalRecords);
    }
}
