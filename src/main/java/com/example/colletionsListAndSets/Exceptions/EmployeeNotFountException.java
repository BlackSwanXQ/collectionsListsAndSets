package com.example.colletionsListAndSets.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFountException extends RuntimeException {
    public EmployeeNotFountException(String message) {
        super(message);
    }

    public EmployeeNotFountException() {
    }
}
