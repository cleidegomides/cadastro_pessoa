package com.everis.cadastro.mappers;

import com.everis.cadastro.model.dto.EnderecoDto;
import com.everis.cadastro.model.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoDto {

    Endereco toEntity(EnderecoDto enderecoDto);

    EnderecoDto toDto(Endereco endereco);

    void toEntityUpdate(EnderecoDto enderecoDto, @MappingTarget Endereco endereco);
}
