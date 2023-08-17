package com.projeto.rosa.entities;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32, nullable = false)
    private String nome;

    @Column(length = 180)
    private String destinacao;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int taxaRentabilidade;

    @Column(nullable = false)
    private int prazoMinimo;

    @Column(nullable = false)
    private int taxaAdministracao;
}
