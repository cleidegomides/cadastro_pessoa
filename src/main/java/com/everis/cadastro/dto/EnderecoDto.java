package com.everis.cadastro.dto;

import lombok.Data;

@Data
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
}
