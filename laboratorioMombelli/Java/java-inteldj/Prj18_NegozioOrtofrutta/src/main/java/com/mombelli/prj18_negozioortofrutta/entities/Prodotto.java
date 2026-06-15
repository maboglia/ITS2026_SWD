package com.mombelli.prj18_negozioortofrutta.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "prodotti_ortofrutticoli")
@Data
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String nome;
    private String categoria;
    private String origine;

    @Column(name = "prezzo_kg")
    private double prezzoKg;

    private String disponibilita;
}
