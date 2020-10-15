package com.everis.cadastro.mappers;

import com.everis.cadastro.model.dto.PessoaDto;
import com.everis.cadastro.model.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {MapperEnderecoEnderecoDto.class})
public interface MapperPessoaPessoaDto {

    Pessoa toEntity(PessoaDto pessoaDto);

    PessoaDto toDto(Pessoa pessoa);

    void toEntityUpdate(PessoaDto pessoaDto, @MappingTarget Pessoa pessoa);
}
