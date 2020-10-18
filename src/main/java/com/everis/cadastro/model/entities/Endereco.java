package com.everis.cadastro.model.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TB_endereco")
public class Endereco {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "logradouro", nullable = false, unique = false)
    private String logradouro;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

}
