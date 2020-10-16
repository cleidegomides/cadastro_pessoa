package com.everis.cadastro.services;

import com.everis.cadastro.model.dto.EnderecoDto;
import com.everis.cadastro.model.entities.Endereco;

import java.util.List;

public interface EnderecoService {

    EnderecoDto create(EnderecoDto enderecoDto);

    List<EnderecoDto> get();

    EnderecoDto get(Long id);

    void delete(Long id);

    EnderecoDto update(EnderecoDto enderecoDto);

    Endereco getEndereco(final Long id);
}
