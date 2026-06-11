package com.maboglia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maboglia.entities.ProdottoBar;
import com.maboglia.repos.ProdottoBarRepo;

@Service
public class ProdottoBarServiceImpl implements ProdottoBarService {

    @Autowired
    private ProdottoBarRepo repo;

    @Override
    public ProdottoBar getProdottoById(int id) {
        
        return repo.findById((long) id).orElse(null);
    }

    @Override
    public List<ProdottoBar> getAllProdotti() {
        return repo.findAll();
    }

    @Override
    public List<ProdottoBar> getProdottiBySezione(String sezione) {
        // TODO Auto-generated method stub
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
            .stream()
            .map(p -> p.getSezione())
            .distinct()
            .sorted()
            .toList();
        
    }

}
