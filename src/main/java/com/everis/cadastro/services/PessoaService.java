package com.everis.cadastro.services;

import com.everis.cadastro.model.dto.PessoaDto;

import java.util.List;

public interface PessoaService {

    PessoaDto create(PessoaDto pessoaDto);

    List<PessoaDto> buscarPessoas();

    PessoaDto buscarPessoaPorId(Long id);

    void delete(Long id);

    PessoaDto update(PessoaDto pessoaDto);

    PessoaDto addAdress(Long idEndereco, Long idPessoa);

    PessoaDto removeAdress(Long idEndereco, Long idPessoa);
}