package com.everis.cadastro.controllers;

import com.everis.cadastro.model.dto.EnderecoDto;
import com.everis.cadastro.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("endereco")
@Api(value = "Cadastro de Pessoa e Endereço")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @ApiOperation(value = "Criar  Endereço no Banco de Dados")
    @PostMapping
    public ResponseEntity<EnderecoDto> create(@RequestBody EnderecoDto enderecoDto1){
        EnderecoDto enderecoDto = enderecoService.create(enderecoDto1);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(enderecoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(enderecoDto1);
    }

    @ApiOperation(value = "Listar os Endereços do Banco de Dados.")
    @GetMapping
    public ResponseEntity<List<EnderecoDto>> get(){
        List<EnderecoDto> enderecoDtos = enderecoService.get();
        return ResponseEntity.ok(enderecoDtos);
    }

    @ApiOperation(value ="Buscar por Endereço no Banco de Dados" )
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> get(@PathVariable Long id){
        EnderecoDto enderecoDto = enderecoService.get(id);
        return ResponseEntity.ok(enderecoDto);
    }

    @ApiOperation(value = "Deletar Endereço do Banco de Dados.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        enderecoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Atualizar Endereço no Banco de Dados.")
    @PutMapping
    public ResponseEntity<EnderecoDto> update(@RequestBody EnderecoDto enderecoDto){
        EnderecoDto enderecoDto1 = enderecoService.update(enderecoDto);
        return ResponseEntity.ok(enderecoDto1);

    }
}
