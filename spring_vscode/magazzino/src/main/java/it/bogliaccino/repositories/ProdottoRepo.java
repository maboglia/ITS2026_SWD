package it.bogliaccino.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bogliaccino.entities.Prodotto;

public interface ProdottoRepo extends JpaRepository<Prodotto, Integer> {

    //derived query per trovare i prodotti per categoria
    public List<Prodotto> findByCategoria(String categoria);

}
