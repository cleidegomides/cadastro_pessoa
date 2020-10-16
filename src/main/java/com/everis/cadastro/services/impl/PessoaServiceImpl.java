package com.everis.cadastro.services.impl;

import com.everis.cadastro.exceptions.PessoaCreateException;
import com.everis.cadastro.exceptions.PessoaNotFoundException;
import com.everis.cadastro.mappers.MapperPessoaPessoaDto;
import com.everis.cadastro.model.dto.PessoaDto;
import com.everis.cadastro.model.entities.Pessoa;
import com.everis.cadastro.repositories.PessoaRepository;
import com.everis.cadastro.services.EnderecoService;
import com.everis.cadastro.services.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.of;

@Service
@Slf4j
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final EnderecoService enderecoService;
    private final MapperPessoaPessoaDto mapperPessoaPessoaDto;

    @Override
    public PessoaDto create(final PessoaDto pessoaDto) {
        return of(mapperPessoaPessoaDto.toEntity(pessoaDto))
                .map(pessoaRepository::save)
                .map(mapperPessoaPessoaDto::toDto)
                .orElseThrow(() -> new PessoaCreateException("Falha ao criar a pessoa: " + pessoaDto));
    }

    @Override
    public List<PessoaDto> buscarPessoas() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    log.info("Pessoa: {}", pessoa);
                    return mapperPessoaPessoaDto.toDto(pessoa);
                })
                .collect(Collectors.toList());
    }

    @Override
    public PessoaDto buscarPessoaPorId(final Long id) {
       return mapperPessoaPessoaDto.toDto(getPessoa(id));
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
    public PessoaDto update(final PessoaDto pessoaDto) {
        return pessoaRepository.findById(pessoaDto.getId())
                .map(pessoa -> {
                    mapperPessoaPessoaDto.toEntityUpdate(pessoaDto, pessoa);
                    return pessoa;
                })
                .map(pessoaRepository::save)
                .map(mapperPessoaPessoaDto::toDto)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id.."));
    }

    @Override
    public PessoaDto addAdress(final Long idEndereco, final Long idPessoa) {
        return of(getPessoa(idPessoa))
                .map(p -> {
                    p.adicionarEndereco(enderecoService.getEndereco(idEndereco));
                    return pessoaRepository.save(p);
                }).map(mapperPessoaPessoaDto::toDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public PessoaDto removeAdress(final Long idEndereco, final Long idPessoa) {
        return of(getPessoa(idPessoa))
                .map(p -> {
                    p.removerEndereco(enderecoService.getEndereco(idEndereco));
                    return pessoaRepository.save(p);
                }).map(mapperPessoaPessoaDto::toDto)
                .orElseThrow(RuntimeException::new);
    }

    private Pessoa getPessoa(final Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id.."));
    }
}
