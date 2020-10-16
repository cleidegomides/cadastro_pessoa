package com.everis.cadastro.controllers;

import com.everis.cadastro.model.dto.PessoaDto;
import com.everis.cadastro.services.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Api(value = "Cadastro de Pessoa e Endereço")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @ApiOperation(value = "Criar Cadastro de Pessoa no Banco de Dados.")
    @PostMapping
    public ResponseEntity<PessoaDto> create(@RequestBody final PessoaDto pessoaDtoRecebidoArgumento){
        final PessoaDto pessoaDtoRetornoDoService = pessoaService.create(pessoaDtoRecebidoArgumento);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaDtoRetornoDoService.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoaDtoRecebidoArgumento);
    }

    @ApiOperation(value = "Listar Cadastro de Pessoas do Banco de Dados.")
    @GetMapping
    public ResponseEntity<List<PessoaDto>> get(){
        final List<PessoaDto> pessoasDtos = pessoaService.buscarPessoas();
        return ResponseEntity.ok(pessoasDtos);
    }

    @ApiOperation(value = "Buscar Cadastro de Pessoa do Banco de Dados.")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> get(@PathVariable Long id){
        final PessoaDto pessoaDto = pessoaService.buscarPessoaPorId(id);
        return ResponseEntity.ok(pessoaDto);
    }

    @ApiOperation(value = "Deletar Cadastro de Pessoa.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id){
        pessoaService.delete(id);
    }

    @ApiOperation(value = "Atualizar Cadastro de Pessoa no Banco de Dados.")
    @PutMapping
    public ResponseEntity<PessoaDto> update(@RequestBody final PessoaDto pessoaDto){
        final PessoaDto pessoaDto1 = pessoaService.update(pessoaDto);
        return ResponseEntity.ok(pessoaDto1);
    }

    @ApiOperation(value = "Adicionar Endereço ao Cadastro Pessoa no Banco de Dados.")
    @PatchMapping("/{idpessoa}/add/{idendereco}")
    public ResponseEntity<PessoaDto> addAddress(@PathVariable final Long idpessoa, @PathVariable final Long idendereco){
        final PessoaDto pessoaDto = pessoaService.addAdress(idendereco, idpessoa);
        return ResponseEntity.ok(pessoaDto);
    }

    @ApiOperation(value = "Remover Endereço do Cadastro de Pessoa.")
    @PatchMapping("/{idpessoa}/remove/{idendereco}")
    public ResponseEntity<PessoaDto> removeAddress(@PathVariable final Long idpessoa, @PathVariable final Long idendereco){
        final PessoaDto pessoaDto = pessoaService.removeAdress(idendereco, idpessoa);
        return ResponseEntity.ok(pessoaDto);
    }
}