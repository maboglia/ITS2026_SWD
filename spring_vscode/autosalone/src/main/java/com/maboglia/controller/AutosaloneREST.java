package com.maboglia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maboglia.entities.Automobile;
import com.maboglia.services.VeicoliService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class AutosaloneREST {


    @Autowired
    private VeicoliService service;

    @GetMapping("automobili")
    public List<Automobile> getAutomobili() {
        return service.getAllAutomobili();
    }
    
    @PostMapping("automobili")
    public Automobile postAutomobile(@RequestBody Automobile automobile) {
        
        return service.addAutomobile(automobile);
    }
    
    



}
