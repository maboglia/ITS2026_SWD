package com.mombelli.prenotazionifilm.dto;

import lombok.Getter;

@Getter
public class PrenotazioneRequest {

    private int filmInsalaId;
    private int postiPrenotati;
    private String nome;
}
