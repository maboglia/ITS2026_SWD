package com.mombelli.relazioni_pericolose.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mombelli.relazioni_pericolose.entities.Libretto;
import com.mombelli.relazioni_pericolose.entities.Studente;

public interface SegreteriaService {

    Studente addStudente(Studente s, Libretto l);
    Libretto addLibretto(Libretto l);
    List<Studente> getStudenti();
    Map<Integer, Studente> getStudentiMap();
    Optional<Studente> getStudenteById( int id);
    Optional<Studente> getStudenteByMatricola(String matricola);
}
