package com.maboglia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.maboglia.entities.ProdottoBar;
import com.maboglia.services.ProdottoBarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProdottiMVC {

    @Autowired
    private ProdottoBarService service;

    @GetMapping("/prodotti")
    public String getMethodName(Model model) {

        model.addAttribute("sezioni", service.getSezioni());
        model.addAttribute("prodotti", service.getAllProdotti());
        model.addAttribute("title", "Listino prezzi Bar");
        return "prodotti";
    }
    
    @PostMapping("/prodotti")
    public String postMethodName(ProdottoBar p) {
        service.addProdotto(p);
        
        return "redirect:/prodotti";
    }
    



}
