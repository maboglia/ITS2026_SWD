package com.mombelli.relazioni_pericolose.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Corso
 */
@Entity
@Table(name = "corsi")
@Data
public class Corso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @JsonIgnore
    @OneToMany (mappedBy = "corso", cascade = CascadeType.ALL)
    private Set<Studente> studenti = new HashSet<>();
    
    
    @JsonIgnore
    @OneToMany (mappedBy = "corso", cascade = CascadeType.ALL)
    private Set<Insegnamento> insegnamenti = new HashSet<>();



}
