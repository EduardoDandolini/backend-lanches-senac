package com.backend.lanchessenac.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApplicationExceptionHandler {


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> BadRequestException(BadRequestException badRequestException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getMessage());
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<String> ConflictException(ConflictException conflictException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(conflictException.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> NotFoundException(NotFoundException notFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundException.getMessage());
    }

}
