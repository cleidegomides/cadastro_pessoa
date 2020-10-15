package com.everis.cadastro.config;

import com.everis.cadastro.model.entities.Endereco;
import com.everis.cadastro.model.entities.Pessoa;
import com.everis.cadastro.repositories.EnderecoRepository;
import com.everis.cadastro.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
public class DadosIniciais {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostConstruct
    public void iniciarDados(){
        if(pessoaRepository.findAll().size() > 0){
            return;
        }

        Endereco e1 = new Endereco();
        e1.setLogradouro("Av. Paraguai");
        e1.setBairro("Roosevelt");
        e1.setCidade("Uberlândia");
        e1.setEstado("MG");
        e1.setNumero(555);

        enderecoRepository.save(e1);

        Endereco e2 = new Endereco();
        e2.setLogradouro("Av. Paraguai");
        e2.setBairro("Roosevelt");
        e2.setCidade("Uberlândia");
        e2.setEstado("MG");
        e2.setNumero(569);

        enderecoRepository.save(e2);

        Pessoa p1 = new Pessoa();
        p1.setNomeCompleto("Cleide Gomides");
        p1.setEnderecos( new ArrayList<>());
        p1.getEnderecos().add(e1);
        p1.getEnderecos().add(e2);

        Pessoa p2 = new Pessoa();
        p2.setNomeCompleto("Vyttor Salgado Topzeira");
        p2.setEnderecos( new ArrayList<>());
        p2.getEnderecos().add(e1);

        pessoaRepository.save(p1);

        pessoaRepository.save(p2);
    }
}
