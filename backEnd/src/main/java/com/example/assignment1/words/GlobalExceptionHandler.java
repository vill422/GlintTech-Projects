package com.example.assignment1.words;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleNotFound(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Bad Request");
    }
}

