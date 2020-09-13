package com.sallu.api.controllers;

import com.sallu.api.controllers.errors.ApiErrors;
import com.sallu.api.services.exceptions.IncorrectDataException;
import com.sallu.api.services.exceptions.InvalidPassowrdException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(IncorrectDataException.class)
    public ResponseEntity<ApiErrors> dadosIncorretos(IncorrectDataException errMessage) {
        return ResponseEntity.status(400).body(new ApiErrors(Collections.singletonList(errMessage.getMessage())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrors> dadosInvalidos(MethodArgumentNotValidException errMessage) {
        List<String> errMessages = errMessage
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.status(400).body(new ApiErrors(errMessages));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrors> constraintErrors(DataIntegrityViolationException errMessage) {
        return ResponseEntity.status(400).body(new ApiErrors(errMessage.getMessage()));
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiErrors> userNotFound(UsernameNotFoundException errMessage) {
        return ResponseEntity.status(404).body(new ApiErrors(errMessage.getMessage()));
    }

    @ExceptionHandler(InvalidPassowrdException.class)
    public ResponseEntity<ApiErrors> senhaInvalida(InvalidPassowrdException errMessage) {
        return ResponseEntity.status(401).body(new ApiErrors(errMessage.getMessage()));
    }
}