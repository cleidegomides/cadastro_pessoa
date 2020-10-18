package com.everis.cadastro.controllers;

import com.everis.cadastro.model.dto.endereco.EnderecoRequestDTO;
import com.everis.cadastro.model.dto.endereco.EnderecoResponseDTO;
import com.everis.cadastro.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("endereco")
@Api(value = "Cadastro de Pessoa e Endereço")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @ApiOperation(value = "Criar  Endereço no Banco de Dados")
    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> create(@RequestBody final EnderecoRequestDTO enderecoRequestDTO){
        final EnderecoResponseDTO enderecoResponseDTO = enderecoService.create(enderecoRequestDTO);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(enderecoResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(enderecoResponseDTO);
    }

    @ApiOperation(value = "Listar os Endereços do Banco de Dados.")
    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> get(){
       final List<EnderecoResponseDTO> enderecoDtos = enderecoService.get();
        return ResponseEntity.ok(enderecoDtos);
    }

    @ApiOperation(value ="Buscar por Endereço no Banco de Dados" )
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> get(@PathVariable final Long id){
        final EnderecoResponseDTO enderecoDto = enderecoService.get(id);
        return ResponseEntity.ok(enderecoDto);
    }

    @ApiOperation(value = "Deletar Endereço do Banco de Dados.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id){
        enderecoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualizar Endereço no Banco de Dados.")
    @PutMapping
    public ResponseEntity<EnderecoResponseDTO> update(@RequestBody final EnderecoRequestDTO enderecoDto){
       final EnderecoResponseDTO enderecoDto1 = enderecoService.update(enderecoDto);
        return ResponseEntity.ok(enderecoDto1);

    }
}
