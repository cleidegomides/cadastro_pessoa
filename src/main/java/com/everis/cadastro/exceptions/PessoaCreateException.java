package com.everis.cadastro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaCreateException extends RuntimeException{
    public PessoaCreateException(String message) {
        super(message);
    }
}
