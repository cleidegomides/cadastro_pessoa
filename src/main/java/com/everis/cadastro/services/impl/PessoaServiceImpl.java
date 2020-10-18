package com.everis.cadastro.services.impl;

import com.everis.cadastro.exceptions.PessoaCreateException;
import com.everis.cadastro.exceptions.PessoaNotFoundException;
import com.everis.cadastro.mappers.MapperPessoaPessoaRequestDTO;
import com.everis.cadastro.mappers.MapperPessoaPessoaResponseDTO;
import com.everis.cadastro.model.dto.pessoa.PessoaRequestDTO;
import com.everis.cadastro.model.dto.pessoa.PessoaResponseDTO;
import com.everis.cadastro.model.entities.Pessoa;
import com.everis.cadastro.repositories.PessoaRepository;
import com.everis.cadastro.services.EnderecoService;
import com.everis.cadastro.services.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;
    private final MapperPessoaPessoaRequestDTO mapperPessoaPessoaRequestDTO;
    private final MapperPessoaPessoaResponseDTO mapperPessoaPessoaResponseDTO;

    @Override
    public PessoaResponseDTO create(final PessoaRequestDTO pessoaRequestDTO) {
        return Optional
                .of( mapperPessoaPessoaRequestDTO.toEntity(pessoaRequestDTO) )
                .map( pessoaRepository::save )
                .map( mapperPessoaPessoaResponseDTO::toDto )
                .orElseThrow(
                        () -> new PessoaCreateException("Falha ao criar a pessoa: " + pessoaRequestDTO))
                ;
    }

    @Override
    public List<PessoaResponseDTO> buscarPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    log.info("Pessoa: {}", pessoa);
                    return mapperPessoaPessoaResponseDTO.toDto(pessoa);
                })
                .collect(Collectors.toList());
    }

    @Override
    public PessoaResponseDTO buscarPessoaPorId(final Long id) {
       return mapperPessoaPessoaResponseDTO.toDto(getPessoa(id));
    }

    @Override
    public void delete(final Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Falha ao deletar a pessoa com id: {}.", id);
        }
    }

    @Override
    public PessoaResponseDTO update(final PessoaRequestDTO pessoaRequestDTO) {
        return pessoaRepository.findById(pessoaRequestDTO.getId())
                .map(pessoa -> {
                    mapperPessoaPessoaRequestDTO.toEntityUpdate(pessoaRequestDTO, pessoa);
                    return pessoa;
                })
                .map(pessoaRepository::save)
                .map(mapperPessoaPessoaResponseDTO::toDto)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id.."))
                ;
    }

    @Override
    public PessoaResponseDTO addAdress(final Long idEndereco, final Long idPessoa) {
        return Optional.of(getPessoa(idPessoa))
                .map(p -> {
                    p.adicionarEndereco(enderecoService.getEndereco(idEndereco));
                    return pessoaRepository.save(p);
                }).map(mapperPessoaPessoaResponseDTO::toDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public PessoaResponseDTO removeAdress(final Long idEndereco, final Long idPessoa) {
        return Optional.of(getPessoa(idPessoa))
                .map(p -> {
                    p.removerEndereco(enderecoService.getEndereco(idEndereco));
                    return pessoaRepository.save(p);
                }).map(mapperPessoaPessoaResponseDTO::toDto)
                .orElseThrow(RuntimeException::new);
    }

    private Pessoa getPessoa(final Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id.."));
    }
}
