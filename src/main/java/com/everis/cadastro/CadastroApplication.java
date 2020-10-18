package com.everis.cadastro;

import com.everis.cadastro.model.entities.Pessoa;
import com.everis.cadastro.repositories.PessoaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackageClasses = Pessoa.class)
@EnableJpaRepositories(basePackageClasses = PessoaRepository.class)
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

}
