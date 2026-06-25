package com.maboglia.integration;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maboglia.entities.Prodotto;
import com.maboglia.services.ProdottoService;

@RestController
@RequestMapping("api")
public class ProdottiRest {

	private final ProdottoService service;
	
	public ProdottiRest(ProdottoService service) {
		this.service = service;
	}
	
	@GetMapping("prodotti")
	public ResponseEntity<List<Prodotto>> getProdotti(){
		return ResponseEntity.ok(service.getProdotti());
	}
	
	@GetMapping("prodotti/{id}")
	public ResponseEntity<Prodotto> getProdottiById(@PathVariable int id){
		if (service.getProdotto(id).isPresent())
			return ResponseEntity.ok(service.getProdotto(id).get());
		else 
			return ResponseEntity.noContent().build();
	}
	
	@PostMapping("prodotti")
	public ResponseEntity<Prodotto> addProdotto( Prodotto p){
		return ResponseEntity.ok(service.addProdotto(p));
	}
	
	@PutMapping("prodotti")
	public ResponseEntity<Prodotto> saveProdotto(Prodotto p){
		return ResponseEntity.ok(service.updateProdotto(p));
	}
	
	@DeleteMapping("prodotti/{id}")
	public ResponseEntity<?> deleteProdotto(@PathVariable int id){
		service.deleteProdotto(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
