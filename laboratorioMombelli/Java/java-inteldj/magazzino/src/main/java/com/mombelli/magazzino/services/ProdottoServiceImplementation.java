package com.mombelli.magazzino.services;

import com.mombelli.magazzino.dto.ProdottoDto;
import com.mombelli.magazzino.entities.Prodotto;
import com.mombelli.magazzino.repositories.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProdottoServiceImplementation implements ProdottoService {

    @Autowired
    private ProdottoRepo repo;
    //Map<Integer, Prodotto> prodotti;
//
    //public ProdottoServiceImplementation(ProdottoRepo repo){
    //    this.prodotti = new HashMap<>();
    //    repo.findAll().forEach(p -> prodotti.put(p.getId(),p));
    //}


    @Override
    public List<Prodotto> getProdotti() {
        //return prodotti.values().stream().toList();
        return repo.findAll();
    }

    @Override
    public Prodotto getProdottoById(int id) {
        //return prodotti.get(id);
        return repo.findById(id).orElse(null);
    }

    @Override
    public Prodotto addProdotto(ProdottoDto prodotto) {
        //return prodotti.put(prodotto.getId(), prodotto);
        return repo.save(new Prodotto(
                prodotto.getNome(),
                prodotto.getCategoria(),
                prodotto.getPrezzo(),
                prodotto.getGiacenza()
        ));
    }

    @Override
    public Prodotto updateProdotto(Prodotto prodotto) {
        //return prodotti.replace(prodotto.getId(), prodotto);
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

    @Override
    public List<String> getDistinctCategorie() {
        return getProdotti()
                .stream()
                .map(Prodotto::getCategoria)
                .distinct()
                .collect(Collectors.toList());
    }
}
