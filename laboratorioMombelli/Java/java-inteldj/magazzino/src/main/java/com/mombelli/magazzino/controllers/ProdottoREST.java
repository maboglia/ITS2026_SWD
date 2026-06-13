package com.mombelli.magazzino.controllers;

import com.mombelli.magazzino.dto.ProdottoDto;
import com.mombelli.magazzino.entities.Prodotto;
import com.mombelli.magazzino.services.ProdottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prodotti")
public class ProdottoREST {

    @Autowired
    private ProdottoService service;


    @GetMapping("")
    public ResponseEntity<List<Prodotto>> getProdotti(){
        return ResponseEntity.ok(service.getProdotti());
    }

    @PostMapping("/aggiungi")
    public ResponseEntity<?> addProdotto(@RequestBody ProdottoDto p){
        return ResponseEntity.ok(service.addProdotto(p));
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<?> deleteProdotto(@PathVariable int id){
        service.deleteProdotto(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modifica")
    public ResponseEntity<?> updateProdotto(@RequestBody Prodotto p){
        return ResponseEntity.ok(service.updateProdotto(p));
    }

    @GetMapping("/filtra/{categoria}")
    public ResponseEntity<List<Prodotto>> getProdottiByCategoria(@PathVariable String categoria){
        return ResponseEntity.ok(service.getProdottiByCategoria(categoria));

    }

    @GetMapping("/categorie")
    public ResponseEntity<?> getCategorie(){
        return ResponseEntity.ok(service.getDistinctCategorie());
    }
}
