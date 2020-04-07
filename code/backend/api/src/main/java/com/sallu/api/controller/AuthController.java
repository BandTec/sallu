package com.sallu.api.controller;

import com.sallu.api.models.UserModel;
import com.sallu.api.models.dto.LoginDTO;
import com.sallu.api.models.dto.TokenDTO;
import com.sallu.api.services.jwt.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private TokenService service;

    @PostMapping
    public ResponseEntity<TokenDTO> authUser(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.accepted().body(this.service.authUser(loginDTO));
    }
}
