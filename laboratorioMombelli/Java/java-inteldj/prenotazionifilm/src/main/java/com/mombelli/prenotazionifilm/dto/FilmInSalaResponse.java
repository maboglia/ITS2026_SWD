package com.mombelli.prenotazionifilm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmInSalaResponse {

    private String nomeCinema;
    private String indirizzo;
    private String telefono;
    private String titolo;
    private String regista;
    private String genere;
    private LocalDateTime data;
    private double prezzo;
    private int posti;
    private int postiRimanenti;
    private int filmInSalaId;
}
