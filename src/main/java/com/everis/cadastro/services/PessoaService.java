package com.everis.cadastro.services;

import com.everis.cadastro.dto.PessoaDto;
import com.everis.cadastro.entities.Pessoa;
import com.everis.cadastro.exceptions.PessoaNotFoundException;
import com.everis.cadastro.mappers.MapperPessoaPessoaDto;
import com.everis.cadastro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private MapperPessoaPessoaDto mapperPessoaPessoaDto;


    public PessoaDto criarCadastroPessoa(PessoaDto pessoaDto){
        List<Pessoa> pessoas = pessoaRepository.findAll();

        if (pessoas == null){
            throw new PessoaNotFoundException("Pessoa não encontrada.");
        }

        Pessoa pessoa = mapperPessoaPessoaDto.toEntity(pessoaDto);
        pessoaRepository.save(pessoa);
        return pessoaDto;
    }
}
