package com.everis.cadastro.mappers;

import com.everis.cadastro.model.dto.endereco.EnderecoResponseDTO;
import com.everis.cadastro.model.entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperEnderecoEnderecoResponseDTO {

    Endereco toEntity(EnderecoResponseDTO enderecoResponseDTO);

    EnderecoResponseDTO toDto(Endereco endereco);

    void toEntityUpdate(EnderecoResponseDTO enderecoResponseDTO, @MappingTarget Endereco endereco);
}
