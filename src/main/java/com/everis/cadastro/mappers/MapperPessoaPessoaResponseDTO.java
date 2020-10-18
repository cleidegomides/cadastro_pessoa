package com.everis.cadastro.mappers;

import com.everis.cadastro.model.dto.pessoa.PessoaResponseDTO;
import com.everis.cadastro.model.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {MapperEnderecoEnderecoResponseDTO.class})
public interface MapperPessoaPessoaResponseDTO {

    Pessoa toEntity(PessoaResponseDTO pessoaRequestDTO);

    PessoaResponseDTO toDto(Pessoa pessoa);

    void toEntityUpdate(PessoaResponseDTO pessoaResponseDTO, @MappingTarget Pessoa pessoa);
}
