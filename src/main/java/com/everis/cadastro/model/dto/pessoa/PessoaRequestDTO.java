package com.everis.cadastro.model.dto.pessoa;

import com.everis.cadastro.model.dto.endereco.EnderecoRequestDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PessoaRequestDTO {
    private Long id;
    private String nomeCompleto;
    private List<EnderecoRequestDTO> enderecos;
}
