package com.everis.cadastro.mappers;

import com.everis.cadastro.model.dto.pessoa.PessoaRequestDTO;
import com.everis.cadastro.model.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {MapperEnderecoEnderecoResponseDTO.class})
public interface MapperPessoaPessoaRequestDTO {

    Pessoa toEntity(PessoaRequestDTO pessoaRequestDTO);

    PessoaRequestDTO toDto(Pessoa pessoa);

    void toEntityUpdate(PessoaRequestDTO pessoaRequestDTO, @MappingTarget Pessoa pessoa);
}
