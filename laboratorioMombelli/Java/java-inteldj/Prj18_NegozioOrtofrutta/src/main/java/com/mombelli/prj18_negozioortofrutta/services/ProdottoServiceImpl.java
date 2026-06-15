package com.mombelli.prj18_negozioortofrutta.services;

import com.mombelli.prj18_negozioortofrutta.entities.Prodotto;
import com.mombelli.prj18_negozioortofrutta.repos.ProdottoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdottoServiceImpl implements ProdottoService {

    @Autowired
    private ProdottoRepo repo;


    @Override
    public List<Prodotto> getProdotti() {
        return repo.findAll();
    }

    @Override
    public List<Prodotto> getProdottiByCategoria(String categoria) {
        return repo.findAllByCategoria(categoria);
    }

    @Override
    public List<Prodotto> getProdottiByOrigine(String origine) {
        return repo.findAllByOrigine(origine);
    }
}
