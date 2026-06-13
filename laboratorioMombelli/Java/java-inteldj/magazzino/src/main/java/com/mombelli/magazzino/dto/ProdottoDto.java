package com.mombelli.magazzino.dto;

import lombok.Getter;

@Getter
public class ProdottoDto {

    private String nome;
    private String categoria;
    private double prezzo;
    private int giacenza;
}
