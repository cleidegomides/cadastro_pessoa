package com.everis.cadastro.services;
import com.everis.cadastro.model.dto.pessoa.PessoaRequestDTO;
import com.everis.cadastro.model.dto.pessoa.PessoaResponseDTO;

import java.util.List;

public interface PessoaService {

    PessoaResponseDTO create(PessoaRequestDTO pessoaRequestDTO);

    List<PessoaResponseDTO> buscarPessoas();

    PessoaResponseDTO buscarPessoaPorId(Long id);

    void delete(Long id);

    PessoaResponseDTO update(PessoaRequestDTO pessoaDto);

    PessoaResponseDTO addAdress(Long idEndereco, Long idPessoa);

    PessoaResponseDTO removeAdress(Long idEndereco, Long idPessoa);
}