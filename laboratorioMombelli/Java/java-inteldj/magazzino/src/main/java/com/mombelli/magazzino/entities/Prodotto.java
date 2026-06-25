package com.mombelli.magazzino.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="prodotti")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String categoria;
    private double prezzo;
    private int giacenza;


    public Prodotto(String nome, String categoria, double prezzo, int giacenza) {
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
        this.giacenza = giacenza;
    }
}
