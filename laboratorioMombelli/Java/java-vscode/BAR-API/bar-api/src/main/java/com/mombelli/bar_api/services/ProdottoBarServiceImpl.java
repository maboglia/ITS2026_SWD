package com.mombelli.bar_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mombelli.bar_api.entities.ProdottoBar;
import com.mombelli.bar_api.repos.ProdottoBarRepo;

@Service
public class ProdottoBarServiceImpl implements ProdottoBarService {

    @Autowired
    private ProdottoBarRepo repo;

    @Override
    public ProdottoBar getProdottoById(int id) {
        return repo.findById((long)id).orElse(null);
    }

    @Override
    public List<ProdottoBar> getAllProdotti() {
        return repo.findAll();
    }

    @Override
    public List<ProdottoBar> getProdottiBySezione(String sezione) {
        return repo.findBySezione(sezione);
    }

    @Override
    public ProdottoBar addProdotto(ProdottoBar prodotto) {
        return repo.save(prodotto);
    }

    @Override
    public ProdottoBar updateProdotto(ProdottoBar prodotto) {
        return repo.save(prodotto);
    }

    @Override
    public void deleteProdotto(int id) {
        repo.deleteById((long) id);
    }

    @Override
    public List<String> getSezioni() {  
        return this.getAllProdotti()
            .stream() // crea un iterabile di quello che ha trovato dentro l'array
            .map(p -> p.getSezione())
            .distinct() //distingue i valori
            .sorted() // ordino
            .toList(); // li mette in una lista
    }
}