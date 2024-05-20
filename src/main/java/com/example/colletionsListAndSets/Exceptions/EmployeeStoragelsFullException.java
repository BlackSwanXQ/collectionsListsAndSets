package com.example.colletionsListAndSets.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.LENGTH_REQUIRED)
public class EmployeeStoragelsFullException extends RuntimeException {
    public EmployeeStoragelsFullException(String message) {
        super(message);
    }
}
