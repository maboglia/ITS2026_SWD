package it.bogliaccino.services;

import java.util.List;

import it.bogliaccino.entities.Prodotto;

public interface ProdottoService {

    List<Prodotto> getProdotti();
    Prodotto getProdottoById(int id);
    Prodotto addProdotto(Prodotto prodotto);
    Prodotto updateProdotto(Prodotto prodotto);
    void deleteProdotto(int id);

    List<Prodotto> getProdottiByCategoria(String categoria);

}
