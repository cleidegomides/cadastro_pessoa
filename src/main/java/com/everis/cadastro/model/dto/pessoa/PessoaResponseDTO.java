package com.everis.cadastro.model.dto.pessoa;

import com.everis.cadastro.model.dto.endereco.EnderecoRequestDTO;
import com.everis.cadastro.model.dto.endereco.EnderecoResponseDTO;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaResponseDTO {
    private Long id;
    private String nomeCompleto;
    private List<EnderecoResponseDTO> enderecos;
}
