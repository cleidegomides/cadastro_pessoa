package com.everis.cadastro.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_pessoa")
public class Pessoa {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    @ManyToMany
    private List<Endereco> enderecos = new ArrayList<>();

    public void adicionarEndereco(final Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void removerEndereco(final Endereco endereco) {
        this.enderecos.remove(endereco);
    }
}
