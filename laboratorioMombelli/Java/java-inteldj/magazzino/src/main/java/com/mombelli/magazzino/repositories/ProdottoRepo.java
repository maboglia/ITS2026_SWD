package com.mombelli.magazzino.repositories;

import com.mombelli.magazzino.entities.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {

    //derived query per trovare i prodotti per categoria
    public List<Prodotto> findByCategoria(String categoria);



}
