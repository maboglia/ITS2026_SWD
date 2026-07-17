package com.mombelli.storia.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anno;
    private String titolo;
    private String luogo;
    private String civilta;
    private String categoria;
    private String descrizione;
}
