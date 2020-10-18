package com.everis.cadastro.mappers;

import com.everis.cadastro.model.dto.endereco.EnderecoRequestDTO;
import com.everis.cadastro.model.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoRequestDTO {


    Endereco toEntity(EnderecoRequestDTO enderecoRequestDTO);

    EnderecoRequestDTO toDto(Endereco endereco);

    void toEntityUpdate(EnderecoRequestDTO enderecoRequestDTO, @MappingTarget Endereco endereco);
}
