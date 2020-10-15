package com.everis.cadastro.handler;

import com.everis.cadastro.exceptions.PessoaNotFoundException;
import com.everis.cadastro.exceptions.erro.PessoaNotFoundDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class PessoaExceptionHandler {
    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<?> handlePessoaNotFoundException(PessoaNotFoundException e){
        PessoaNotFoundDetails pessoaNotFoundDetails = PessoaNotFoundDetails.PessoaNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Pessoa não encontrada.")
                .detail(e.getMessage())
                .developerMessage(e.getClass().getName())
                .build();
        return new ResponseEntity<>(pessoaNotFoundDetails, HttpStatus.NOT_FOUND);
    }
}
