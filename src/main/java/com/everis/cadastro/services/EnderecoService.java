package com.everis.cadastro.services;

import com.everis.cadastro.model.dto.endereco.EnderecoRequestDTO;
import com.everis.cadastro.model.dto.endereco.EnderecoResponseDTO;
import com.everis.cadastro.model.entities.Endereco;
import java.util.List;

public interface EnderecoService {

    EnderecoResponseDTO create(EnderecoRequestDTO enderecoRequestDTO);

    EnderecoResponseDTO get(Long id);

    List<EnderecoResponseDTO> get();

    void delete(Long id);

    EnderecoResponseDTO update(EnderecoRequestDTO enderecoRequestDTO);

    Endereco getEndereco(final Long id);
}
