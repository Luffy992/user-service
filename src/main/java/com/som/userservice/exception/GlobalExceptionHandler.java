package com.som.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            EmailAlreadyExistsException.class
    )
    @ResponseStatus(
            HttpStatus.BAD_REQUEST
    )
    public String handleEmailAlreadyExists(
            EmailAlreadyExistsException ex) {

        return ex.getMessage();
    }
}