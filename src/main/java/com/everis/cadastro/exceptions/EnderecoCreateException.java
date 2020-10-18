package com.everis.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EnderecoCreateException extends RuntimeException{
    public EnderecoCreateException(String message) {
        super(message);
    }
}
