package com.everis.cadastro.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoaDto {
    private Long id;
    private String nomeCompleto;

    private List<EnderecoDto> enderecos;
}
