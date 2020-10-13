package com.everis.cadastro.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TB_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

}
