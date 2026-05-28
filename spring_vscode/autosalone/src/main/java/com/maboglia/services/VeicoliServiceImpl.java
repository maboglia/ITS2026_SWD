package com.maboglia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maboglia.entities.Automobile;
import com.maboglia.repos.AutomobiliRepo;

@Service
public class VeicoliServiceImpl implements VeicoliService {

    @Autowired
    private  AutomobiliRepo automobiliRepo;

    @Override
    public Automobile addAutomobile(Automobile a) {
        
        return automobiliRepo.save(a);
    }

    @Override
    public Automobile updateAutomobile(Automobile a) {
        
        return automobiliRepo.save(a);

    }

    @Override
    public void deleteAutomobile(int id) {
        
        automobiliRepo.deleteById(id);
    }

    @Override
    public Automobile getAutomobileById(int id) {
        
        return automobiliRepo.findById(id).orElse(null);

    }

    @Override
    public List<Automobile> getAllAutomobili() {
        return automobiliRepo.findAll();

    }

}
