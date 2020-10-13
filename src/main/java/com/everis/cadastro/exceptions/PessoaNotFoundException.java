package com.everis.cadastro.exceptions;

public class PessoaNotFoundException extends RuntimeException{
    public PessoaNotFoundException(String message) {
        super(message);
    }
}
