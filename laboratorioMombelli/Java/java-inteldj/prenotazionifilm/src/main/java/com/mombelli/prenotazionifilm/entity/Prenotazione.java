package com.mombelli.prenotazionifilm.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "prenotazioni")
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_filminsala")
    private FilmInSala filmInSala;

    private String nome;
    private int postiPrenotazioni;
}
