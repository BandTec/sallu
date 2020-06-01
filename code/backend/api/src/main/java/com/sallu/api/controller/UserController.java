package com.sallu.api.controller;

import com.sallu.api.entities.User;
import com.sallu.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

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
}
