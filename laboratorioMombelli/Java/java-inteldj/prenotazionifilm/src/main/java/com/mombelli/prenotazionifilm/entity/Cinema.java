package com.mombelli.prenotazionifilm.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cinema")
@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeCinema;
    private String indirizzo;
    private String telefono;
    private int posti;

}
