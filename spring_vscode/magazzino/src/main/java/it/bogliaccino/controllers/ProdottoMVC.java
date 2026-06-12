package it.bogliaccino.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import it.bogliaccino.entities.Prodotto;
import it.bogliaccino.services.ProdottoService;





@Controller
public class ProdottoMVC {

    @Autowired
    private ProdottoService service;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @PostMapping("")
    public String addProdotto(Prodotto p) {
        service.addProdotto(p);
        
        return "redirect:/";
    }
    


}
