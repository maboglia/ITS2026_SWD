package com.mombelli.prj18_negozioortofrutta.controllers;

import com.mombelli.prj18_negozioortofrutta.entities.Prodotto;
import com.mombelli.prj18_negozioortofrutta.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdottoREST {

    @Autowired
    private ProdottoService service;

    @GetMapping("/negozio")
    public List<Prodotto> getProdotti(){
        return service.getProdotti();
    }

    @GetMapping("/negozio/categoria/{cat}")
    public ResponseEntity<List<Prodotto>> getProdottiCategoria(@PathVariable String cat){
        return ResponseEntity.ok(service.getProdottiByCategoria(cat));
    }

    @GetMapping("/negozio/origine/{origine}")
    public ResponseEntity<List<Prodotto>> getProdottiOrigine(@PathVariable String origine){
        return ResponseEntity.ok(service.getProdottiByOrigine(origine));
    }


}
