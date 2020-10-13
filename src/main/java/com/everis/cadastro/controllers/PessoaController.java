package com.everis.cadastro.controllers;

import com.everis.cadastro.dto.PessoaDto;
import com.everis.cadastro.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<PessoaDto> criarPessoa(@RequestBody PessoaDto pessoaDto){
        pessoaService.criarCadastroPessoa(pessoaDto);
        return ResponseEntity.ok(pessoaDto);
    }
}
