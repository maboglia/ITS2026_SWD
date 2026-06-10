package com.mombelli.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mombelli.model.Maglia;
import com.mombelli.services.TShirtService;

@RestController
public class AbbigliamentoREST {

	@Autowired
	private TShirtService service;
	
	
	@GetMapping("/api/magliette")
	public List<Maglia> getMagliette(){
		return service.getMagliette();
	}
}
