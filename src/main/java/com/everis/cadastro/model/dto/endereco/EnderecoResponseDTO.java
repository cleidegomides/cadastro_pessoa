package com.everis.cadastro.model.dto.endereco;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnderecoResponseDTO {

    private Long id;
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
}
