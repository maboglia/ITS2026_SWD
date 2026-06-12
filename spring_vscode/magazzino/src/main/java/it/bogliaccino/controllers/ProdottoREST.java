package it.bogliaccino.controllers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bogliaccino.entities.Prodotto;
import it.bogliaccino.services.ProdottoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/prodotti")
public class ProdottoREST {

    @Autowired
    private ProdottoService service;

    @GetMapping("")
    public ResponseEntity<List<Prodotto>> getProdotti() {
        return ResponseEntity.ok(service.getProdotti());
    }

    @GetMapping("/categorie")
    public ResponseEntity<Set<String>> getCategorie() {
        return ResponseEntity.ok(service.getProdotti().stream().map(Prodotto::getCategoria).sorted().collect(Collectors.toSet()));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Prodotto>> getProdottiByCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(service.getProdottiByCategoria(categoria));
    }
    

    @PostMapping("")
    public ResponseEntity<Prodotto> postProdotto(@RequestBody Prodotto prodotto) {
        return ResponseEntity.ok(service.addProdotto(prodotto));
    }
    
    @PutMapping("")
    public ResponseEntity<Prodotto> putProdotto(@RequestBody Prodotto prodotto) {
        return ResponseEntity.ok(service.updateProdotto(prodotto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProdotto(@PathVariable int id) {
        service.deleteProdotto(id);
        return ResponseEntity.ok("Prodotto con id " + id + " cancellato");
    }


}
