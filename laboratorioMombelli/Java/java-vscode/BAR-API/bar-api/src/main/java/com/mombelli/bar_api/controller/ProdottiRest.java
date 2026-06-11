package com.mombelli.bar_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mombelli.bar_api.entities.ProdottoBar;
import com.mombelli.bar_api.services.ProdottoBarService;


@RestController
@RequestMapping("/api/prodotti")
public class ProdottiRest {

    @Autowired
    private ProdottoBarService service;

    @GetMapping("")
    public ResponseEntity<List<ProdottoBar>> prodotti() {
        return ResponseEntity.ok(service.getAllProdotti());
    }


    @GetMapping("/sezione/{sezione}")
    public ResponseEntity<List<ProdottoBar>> prodottiPerSezione(@PathVariable String sezione) {
        return ResponseEntity.ok(service.getProdottiBySezione(sezione));
    }

    @GetMapping("/sezioni")
    public ResponseEntity<List<String>> sezioni() {
        return ResponseEntity.ok(service.getSezioni());
    }

    @PostMapping("")
    public ResponseEntity<ProdottoBar> addProdotto(@RequestBody ProdottoBar p) {
        return ResponseEntity.ok(service.addProdotto(p));
    }
    
    @PostMapping("/tantiprodotti")
    public ResponseEntity<List<ProdottoBar>> addProdotti(@RequestBody List<ProdottoBar> prodotti) {
        //for (ProdottoBar p : prodotti) {
        //    service.addProdotto(p);
        //}


        prodotti.stream().forEach(service::addProdotto);

        return ResponseEntity.ok(prodotti);
    }

}
