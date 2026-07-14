package com.mombelli.prenotazionifilm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "film_in_sala")
@Entity
public class FilmInSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    private LocalDateTime data;

    private double prezzo;

    private int postiRimanenti;
}
