package com.maboglia.storia.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "eventi")
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
