package com.mombelli.relazioni_pericolose.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mombelli.relazioni_pericolose.entities.Libretto;
import com.mombelli.relazioni_pericolose.entities.Studente;
import com.mombelli.relazioni_pericolose.repository.LibrettoRepository;
import com.mombelli.relazioni_pericolose.repository.StudenteRepository;

@Service
public class SegreteriaServiceImpl implements SegreteriaService {

    private final StudenteRepository repoStudenti;
    private final LibrettoRepository repoLibretti;
    private final Map<Integer, Studente> studentiMap;

    public SegreteriaServiceImpl(StudenteRepository studenteRepository, LibrettoRepository librettoRepository, Map<Integer, Studente> studentiMap) {
        this.repoStudenti = studenteRepository;
        this.repoLibretti = librettoRepository;
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
        return repoStudenti.findAll();
    }

    @Override
    public Libretto addLibretto(Libretto l) {
        return repoLibretti.save(l);
    }

    @Override
    public Map<Integer, Studente> getStudentiMap() {
        for (Studente s : this.getStudenti()) {
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
        for (Studente s : getStudenti()) {
            if (s.getLibretto().getNumeroMatricola().equals(matricola)){
                return getStudenteById(s.getId());
            }
             
        }
        return null;
    }
    

}
