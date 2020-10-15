package com.everis.cadastro.handler;

import com.everis.cadastro.exceptions.EnderecoNotFoundException;
import com.everis.cadastro.exceptions.erro.EnderecoNotFoundDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class EnderecoExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<?> handleEnderecoNotFoundException(EnderecoNotFoundException e){
        EnderecoNotFoundDetails enderecoNotFoundDetails = EnderecoNotFoundDetails.EnderecoNotFoundDetailsBuilder.newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Endereço não encontrado.")
                .detail(e.getMessage())
                .developerMessage(e.getClass().getName())
                .build();
        return new ResponseEntity<>(enderecoNotFoundDetails, HttpStatus.NOT_FOUND);
    }
}
