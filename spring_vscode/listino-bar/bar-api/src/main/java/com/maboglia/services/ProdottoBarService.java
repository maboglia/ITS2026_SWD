package com.maboglia.services;

import java.util.List;

import com.maboglia.entities.ProdottoBar;

public interface ProdottoBarService {

    ProdottoBar getProdottoById(int id);
    List<ProdottoBar> getAllProdotti();
    List<ProdottoBar> getProdottiBySezione(String sezione);

    List<String> getSezioni();
    
    ProdottoBar addProdotto(ProdottoBar prodotto);
    ProdottoBar updateProdotto(ProdottoBar prodotto);
    void deleteProdotto(int id);

}
