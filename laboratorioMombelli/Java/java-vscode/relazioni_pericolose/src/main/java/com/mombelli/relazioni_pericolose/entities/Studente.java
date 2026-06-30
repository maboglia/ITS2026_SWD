package com.mombelli.relazioni_pericolose.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "studenti")
@Data
public class Studente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cognome;


    @OneToOne(mappedBy = "studente", cascade = CascadeType.ALL)
    private Libretto libretto;


    @ManyToOne
    private Corso corso;


}
