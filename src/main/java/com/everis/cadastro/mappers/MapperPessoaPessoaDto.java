package com.everis.cadastro.mappers;

import com.everis.cadastro.dto.PessoaDto;
import com.everis.cadastro.entities.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapperPessoaPessoaDto {

    Pessoa toEntity(PessoaDto pessoaDto);

    PessoaDto toDto(Pessoa pessoa);
}
