package com.catalisa.biblioteca.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "TBL_LIVROS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LivrosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 50, nullable = false)
    private String autor;
    @Column(length = 20, nullable = false)
    private String dataDeLancamento;
    @Column(length = 50, nullable = false)
    private String codigoDoLivro;

}
