package com.mombelli.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mombelli.entities.Automobile;
import com.mombelli.services.ServizioVeicoli;

@RestController
@RequestMapping("api")
public class AutosaloneREST {
	
	// a default parla in json
	
	@Autowired
	private ServizioVeicoli service;

	@GetMapping("automobili")
	public List<Automobile> automobili(){
		
		Automobile a = new Automobile("fiat","punto", 1000, 5000);
		Automobile b = new Automobile("ford","fiesta", 1100, 5500);
		
		return service.getAutomobili();
	}
	
	@PostMapping("automobili")
	public Automobile postAutomobile(@RequestBody Automobile automobile) {
		
		return service.addAutomobile(automobile);
	}

}
