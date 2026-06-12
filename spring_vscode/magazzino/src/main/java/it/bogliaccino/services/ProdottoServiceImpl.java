package it.bogliaccino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bogliaccino.entities.Prodotto;
import it.bogliaccino.repositories.ProdottoRepo;

@Service
public class ProdottoServiceImpl implements ProdottoService {

    @Autowired
    private ProdottoRepo repo;
  
    @Override
    public List<Prodotto> getProdotti() {

        return repo.findAll();
    }

    @Override
    public Prodotto getProdottoById(int id) {
        return repo.findById(id).orElse(null);
    }



    @Override
    public Prodotto addProdotto(Prodotto prodotto) {
        return repo.save(prodotto);

    }

    @Override
    public Prodotto updateProdotto(Prodotto prodotto) {

        return repo.save(prodotto);
    }

    @Override
    public void deleteProdotto(int id) {

        repo.deleteById(id);
    }

    @Override
    public List<Prodotto> getProdottiByCategoria(String categoria) {

        return repo.findByCategoria(categoria);
    }


    

}
