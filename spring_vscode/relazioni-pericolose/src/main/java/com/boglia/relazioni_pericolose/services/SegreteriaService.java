package com.boglia.relazioni_pericolose.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.boglia.relazioni_pericolose.entities.Libretto;
import com.boglia.relazioni_pericolose.entities.Studente;

public interface SegreteriaService {

    Studente addStudente(Studente s, Libretto l);
    Libretto addLibretto(Libretto s);
    
    List<Studente> getStudenti();
    Map<Integer,Studente> getStudentiMap();
    Optional<Studente> getStudenteById(int id);
    Optional<Studente> getStudenteByMatricola(String matricola);


}
