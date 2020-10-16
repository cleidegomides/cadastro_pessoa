package com.everis.cadastro.services.impl;

import com.everis.cadastro.exceptions.EnderecoNotFoundException;
import com.everis.cadastro.mappers.MapperEnderecoEnderecoDto;
import com.everis.cadastro.model.dto.EnderecoDto;
import com.everis.cadastro.model.entities.Endereco;
import com.everis.cadastro.repositories.EnderecoRepository;
import com.everis.cadastro.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoServiceImpl implements EnderecoService {


    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MapperEnderecoEnderecoDto mapperEnderecoEnderecoDto;

    @Override
    public EnderecoDto create(EnderecoDto enderecoDto) {
        Endereco endereco = mapperEnderecoEnderecoDto.toEntity(enderecoDto);

       endereco = enderecoRepository.save(endereco);

       EnderecoDto enderecoDto1 = mapperEnderecoEnderecoDto.toDto(endereco);

        return enderecoDto1;
    }

    @Override
    public List<EnderecoDto> get() {
        List<Endereco> enderecos = enderecoRepository.findAll();

        List<EnderecoDto> enderecoDtos = enderecos
                .stream()
                .map(endereco -> {
                    return mapperEnderecoEnderecoDto.toDto(endereco);
                })
                .collect(Collectors.toList());

        return enderecoDtos;
    }

    @Override
    public EnderecoDto get(Long id) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);

        Endereco endereco = optionalEndereco
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado para esse Id."));

        EnderecoDto enderecoDto = mapperEnderecoEnderecoDto.toDto(endereco);

        return enderecoDto;
    }

    @Override
    public void delete(Long id) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(id);

        Endereco endereco = optionalEndereco
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado para esse Id."));

        enderecoRepository.delete(endereco);
    }

    @Override
    public EnderecoDto update(EnderecoDto enderecoDto) {
        Optional<Endereco> optionalEndereco = enderecoRepository.findById(enderecoDto.getId());

        Endereco endereco = optionalEndereco
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado para esse Id."));

        mapperEnderecoEnderecoDto.toEntityUpdate(enderecoDto, endereco);
        enderecoRepository.save(endereco);

        EnderecoDto enderecoDto1 = mapperEnderecoEnderecoDto.toDto(endereco);

        return enderecoDto1;
    }

    @Override
    public Endereco getEndereco(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado para esse Id."));
    }
}
