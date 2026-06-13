package com.mombelli.magazzino.services;


import com.mombelli.magazzino.dto.ProdottoDto;
import com.mombelli.magazzino.entities.Prodotto;

import java.util.List;

public interface ProdottoService {

    List<Prodotto> getProdotti();
    Prodotto getProdottoById(int id);
    Prodotto addProdotto(ProdottoDto prodotto);
    Prodotto updateProdotto(Prodotto prodotto);
    void deleteProdotto(int id);

    List<Prodotto> getProdottiByCategoria(String categoria);

    List<String> getDistinctCategorie();

}
