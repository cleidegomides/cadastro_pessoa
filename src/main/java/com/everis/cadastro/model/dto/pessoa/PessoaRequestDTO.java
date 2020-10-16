package com.everis.cadastro.model.dto.pessoa;

import com.everis.cadastro.model.dto.EnderecoDto;
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

    private String nomeCompleto;
    private List<EnderecoDto> enderecos;
}
