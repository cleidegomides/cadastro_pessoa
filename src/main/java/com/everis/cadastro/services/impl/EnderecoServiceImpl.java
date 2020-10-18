package com.everis.cadastro.services.impl;

import com.everis.cadastro.exceptions.EnderecoCreateException;
import com.everis.cadastro.exceptions.EnderecoNotFoundException;
import com.everis.cadastro.mappers.MapperEnderecoEnderecoRequestDTO;
import com.everis.cadastro.mappers.MapperEnderecoEnderecoResponseDTO;
import com.everis.cadastro.model.dto.endereco.EnderecoRequestDTO;
import com.everis.cadastro.model.dto.endereco.EnderecoResponseDTO;
import com.everis.cadastro.model.entities.Endereco;
import com.everis.cadastro.repositories.EnderecoRepository;
import com.everis.cadastro.services.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {



    private final EnderecoRepository enderecoRepository;
    private final MapperEnderecoEnderecoRequestDTO mapperEnderecoEnderecoRequestDTO;
    private final MapperEnderecoEnderecoResponseDTO mapperEnderecoEnderecoResponseDTO;


    @Override
    public EnderecoResponseDTO create(final EnderecoRequestDTO enderecoRequestDTO) {
        return Optional
                .of(mapperEnderecoEnderecoRequestDTO.toEntity(enderecoRequestDTO))
                .map(enderecoRepository::save)
                .map(mapperEnderecoEnderecoResponseDTO::toDto)
                .orElseThrow(
                        ()-> new EnderecoCreateException("Falha ao criar o endereço" + enderecoRequestDTO))
                ;
    }


    @Override
    public List<EnderecoResponseDTO> get() {
        return  enderecoRepository.findAll()
                .stream()
                .map(endereco -> {
                    log.info("Endereco:{}", endereco);
                    return mapperEnderecoEnderecoResponseDTO.toDto(endereco);
                })
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoResponseDTO get(final Long id) {
        return mapperEnderecoEnderecoResponseDTO.toDto(getEndereco(id));
    }

    @Override
    public void delete(final Long id) {
        try {
            enderecoRepository.deleteById(id);
        }catch (Exception e){
            log.error("Falha ao deletar o endereço com id: {}", id);
        }
    }

    @Override
    public EnderecoResponseDTO update(EnderecoRequestDTO enderecoRequestDTO) {
        return enderecoRepository.findById(enderecoRequestDTO.getId())
                .map(endereco -> {
                    mapperEnderecoEnderecoRequestDTO.toEntityUpdate(enderecoRequestDTO,endereco);
                    return endereco;
                })
                    .map(enderecoRepository::save)
                    .map(mapperEnderecoEnderecoResponseDTO::toDto)
                    .orElseThrow(() -> new EnderecoNotFoundException("Endereço não enconrado para o id."))
                ;
    }

    @Override
    public Endereco getEndereco(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new EnderecoNotFoundException("Endereço não encontrado para esse Id."));
    }

}
