package com.mombelli.prj18_negozioortofrutta.repos;

import com.mombelli.prj18_negozioortofrutta.entities.Prodotto;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdottoRepo extends JpaRepository<Prodotto, Integer > {

    List<Prodotto> findAllByCategoria(String categoria);
    List<Prodotto> findAllByOrigine(String origine);

}
