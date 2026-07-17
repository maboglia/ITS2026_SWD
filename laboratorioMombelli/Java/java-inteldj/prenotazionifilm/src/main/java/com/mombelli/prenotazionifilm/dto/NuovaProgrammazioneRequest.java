package com.mombelli.prenotazionifilm.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NuovaProgrammazioneRequest {

    private int idFilm;
    private int idCinema;
    private LocalDateTime data;
    private double prezzo;

}
