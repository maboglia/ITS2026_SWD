package com.boglia.relazioni_pericolose.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boglia.relazioni_pericolose.entities.Libretto;
import com.boglia.relazioni_pericolose.entities.Studente;
import com.boglia.relazioni_pericolose.repos.LibrettoRepository;
import com.boglia.relazioni_pericolose.repos.StudenteRepository;

@Service
public class SegreteriaServiceImpl implements SegreteriaService {

    private final StudenteRepository repoStudenti;
    private final LibrettoRepository repoLibretti;
    private Map<Integer, Studente> studentiMap;
    
    public SegreteriaServiceImpl(StudenteRepository repoStudenti, LibrettoRepository repoLibretti){
        this.repoStudenti = repoStudenti;
        this.repoLibretti = repoLibretti;
        this.studentiMap = new HashMap<>();
    }


    @Override
    public Studente addStudente(Studente s, Libretto l) {
        s.setLibretto(l);
        l.setStudente(s);
        
        return repoStudenti.save(s);
    }

    @Override
    public List<Studente> getStudenti() {
        return this.repoStudenti.findAll();
    }

    

    @Override
    public Map<Integer, Studente> getStudentiMap() {
        for (Studente s : this.getStudenti()){
            studentiMap.put(s.getId(), s);
        }
        return studentiMap;
    }

    @Override
    public Optional<Studente> getStudenteById(int id) {
        return repoStudenti.findById(id);
    }

    @Override
    public Optional<Studente> getStudenteByMatricola(String matricola) {
        for (Studente s : getStudenti()){
            if (s.getLibretto().getNumeroMatricola().equals(matricola))
                return getStudenteById(s.getId());
        }

        return null;
    }


    @Override
    public Libretto addLibretto(Libretto l) {
        return repoLibretti.save(l);
    }

}
