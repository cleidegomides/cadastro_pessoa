package com.everis.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoNotFoundException extends RuntimeException {
    public EnderecoNotFoundException(String message) {
        super(message);
    }
}
