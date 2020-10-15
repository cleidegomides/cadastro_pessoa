package com.everis.cadastro.services.impl;

import com.everis.cadastro.exceptions.EnderecoNotFoundException;
import com.everis.cadastro.exceptions.PessoaNotFoundException;
import com.everis.cadastro.mappers.MapperPessoaPessoaDto;
import com.everis.cadastro.model.dto.PessoaDto;
import com.everis.cadastro.model.entities.Endereco;
import com.everis.cadastro.model.entities.Pessoa;
import com.everis.cadastro.repositories.EnderecoRepository;
import com.everis.cadastro.repositories.PessoaRepository;
import com.everis.cadastro.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private MapperPessoaPessoaDto mapperPessoaPessoaDto;

    @Override
    public PessoaDto create(PessoaDto pessoaDto) {
        Pessoa pessoa = mapperPessoaPessoaDto.toEntity(pessoaDto);

        pessoa = pessoaRepository.save(pessoa);

        PessoaDto pessoaDto1 = mapperPessoaPessoaDto.toDto(pessoa);

        return pessoaDto1;
    }

    @Override
    public List<PessoaDto> get() {
        List<Pessoa> pessoas = pessoaRepository.findAll();

        List<PessoaDto> pessoaDtos = pessoas
                .stream()
                .map(pessoa -> {
                    return mapperPessoaPessoaDto.toDto(pessoa);
                })
                .collect(Collectors.toList());

        return pessoaDtos;
    }

    @Override
    public PessoaDto get(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);

        Pessoa pessoa = optionalPessoa
                            .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id..") );

        PessoaDto pessoaDto = mapperPessoaPessoaDto.toDto(pessoa);

        return pessoaDto;
    }

    @Override
    public void delete(Long id) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);

        Pessoa pessoa = optionalPessoa
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id."));

        pessoaRepository.delete(pessoa);
    }

    @Override
    public PessoaDto update(PessoaDto pessoaDto) {
        Optional<Pessoa> optionalPessoa = pessoaRepository.findById(pessoaDto.getId());

        Pessoa pessoa = optionalPessoa
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para o id.."));

        mapperPessoaPessoaDto.toEntityUpdate(pessoaDto, pessoa);

        pessoaRepository.save(pessoa);

        PessoaDto pessoaDto1 = mapperPessoaPessoaDto.toDto(pessoa);

        return pessoaDto1;
    }

    @Override
    public PessoaDto addAdress(Long idEndereco, Long idPessoa) {
       Pessoa pessoa = pessoaRepository.findById(idPessoa).get();

       if(pessoa == null){
           throw new PessoaNotFoundException("Pessoa não encontrada para o id.");
       }

       Endereco endereco = enderecoRepository.findById(idEndereco).get();

       if(endereco == null){
           throw new EnderecoNotFoundException("Endereço não encontrado");
       }

       pessoa.getEnderecos().add(endereco);

       pessoaRepository.save(pessoa);

       PessoaDto pessoaDto = mapperPessoaPessoaDto.toDto(pessoa);

       return pessoaDto;
    }

    @Override
    public PessoaDto removeAdress(Long idEndereco, Long idPessoa) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).get();

        if(pessoa == null){
            throw new PessoaNotFoundException("Pessoa não encontrada para o id.");
        }

        for (Endereco endereco : pessoa.getEnderecos()) {
            if(endereco.getId().equals(idEndereco)){
                pessoa.getEnderecos().remove(endereco);
                break;
            }
        }

        pessoaRepository.save(pessoa);

        PessoaDto pessoaDto = mapperPessoaPessoaDto.toDto(pessoa);

        return pessoaDto;
    }
}
