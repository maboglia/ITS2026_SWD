package com.mombelli.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mombelli.model.Maglia;
import com.mombelli.model.Prodotto;
import com.mombelli.services.TShirtService;

@RestController
public class AbbigliamentoREST {

	@Autowired
	private TShirtService service;
	
	
	@GetMapping("/api/magliette")
	public List<Maglia> getMagliette(){
		return service.getMagliette();
	}
	
	
	@GetMapping("/api/prodotti")
	public ResponseEntity<List<Prodotto>> getProdotti(){
		return ResponseEntity.ok(service.getProdotti());
	}
	
	@GetMapping("/api/prodotti/categoria/{cat}")
	public ResponseEntity<List<Prodotto>> getProdotti(@PathVariable String cat){
		return ResponseEntity.ok(service.getProdottiByCayegory(cat));
	}
}
