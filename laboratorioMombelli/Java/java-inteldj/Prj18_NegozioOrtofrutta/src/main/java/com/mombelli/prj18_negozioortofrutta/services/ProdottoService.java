package com.mombelli.prj18_negozioortofrutta.services;


import com.mombelli.prj18_negozioortofrutta.entities.Prodotto;

import java.util.List;

public interface ProdottoService {

    List<Prodotto> getProdotti();
    List<Prodotto> getProdottiByCategoria(String categoria);
    List<Prodotto> getProdottiByOrigine(String origine);

}
