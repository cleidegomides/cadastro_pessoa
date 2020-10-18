package com.everis.cadastro.controllers;

import com.everis.cadastro.model.dto.pessoa.PessoaRequestDTO;
import com.everis.cadastro.model.dto.pessoa.PessoaResponseDTO;
import com.everis.cadastro.services.PessoaService;
import com.everis.cadastro.services.impl.PessoaServiceImpl;
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
    public ResponseEntity<PessoaResponseDTO> create(@RequestBody final PessoaRequestDTO pessoaRequestDTO){
        final PessoaResponseDTO pessoaDtoRetornoDoService = pessoaService.create(pessoaRequestDTO);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pessoaDtoRetornoDoService.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoaDtoRetornoDoService);
    }

    @ApiOperation(value = "Listar Cadastro de Pessoas do Banco de Dados.")
    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> get(){
        final List<PessoaResponseDTO> pessoaResponseDTOS = pessoaService.buscarPessoas();
        return ResponseEntity.ok(pessoaResponseDTOS);
    }

    @ApiOperation(value = "Buscar Cadastro de Pessoa do Banco de Dados.")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> get(@PathVariable final Long id){
        final PessoaResponseDTO pessoaResponseDTO = pessoaService.buscarPessoaPorId(id);
        return ResponseEntity.ok(pessoaResponseDTO);
    }

    @ApiOperation(value = "Deletar Cadastro de Pessoa.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id){
        pessoaService.delete(id);
    }

    @ApiOperation(value = "Atualizar Cadastro de Pessoa no Banco de Dados.")
    @PutMapping
    public ResponseEntity<PessoaResponseDTO> update(@RequestBody final PessoaRequestDTO pessoaDto){
        final PessoaResponseDTO pessoaDto1 = pessoaService.update(pessoaDto);
        return ResponseEntity.ok(pessoaDto1);
    }

    @ApiOperation(value = "Adicionar Endereço ao Cadastro Pessoa no Banco de Dados.")
    @PatchMapping("/{idpessoa}/add/{idendereco}")
    public ResponseEntity<PessoaResponseDTO> addAddress(@PathVariable final Long idpessoa, @PathVariable final Long idendereco){
        final PessoaResponseDTO pessoaDto = pessoaService.addAdress(idendereco, idpessoa);
        return ResponseEntity.ok(pessoaDto);
    }

    @ApiOperation(value = "Remover Endereço do Cadastro de Pessoa.")
    @PatchMapping("/{idpessoa}/remove/{idendereco}")
    public ResponseEntity<PessoaResponseDTO> removeAddress(@PathVariable final Long idpessoa, @PathVariable final Long idendereco){
        final PessoaResponseDTO pessoaResponseDTO = pessoaService.removeAdress(idendereco, idpessoa);
        return ResponseEntity.ok(pessoaResponseDTO);
    }
}