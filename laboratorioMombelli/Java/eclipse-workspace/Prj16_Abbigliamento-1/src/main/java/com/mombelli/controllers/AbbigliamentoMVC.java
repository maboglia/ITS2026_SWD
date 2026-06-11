package com.mombelli.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mombelli.model.Maglia;
import com.mombelli.model.Prodotto;
import com.mombelli.services.TShirtService;

@Controller
public class AbbigliamentoMVC {
// gestisce le rotte e l'instradamento
	
	@Autowired
	private TShirtService service;
	
	//@RequestMapping(method = RequestMethod.GET )
	@GetMapping(path = {"","home","index"})
	public String home(Model m) {
		List<Maglia> magliette = service.getMagliette();
		//serve per collegare il controller con la vista e passare alla view le info
		m.addAttribute("shirts",magliette);
		return "home";
	}
	
	@PostMapping("/prodotti")
	@ResponseBody
	public String postMethodName(Prodotto p) {
		
		return service.addProdotto(p).toString();
		
	}
	
	
}
