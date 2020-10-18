package com.everis.cadastro.model.dto.endereco;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoRequestDTO {

    private Long id;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
}
