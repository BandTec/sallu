package com.sallu.api.controller.errors;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String errors) {
        this.errors = Collections.singletonList(errors);
    }

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }
}
