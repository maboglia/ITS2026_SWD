package com.mombelli.cinema.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "film_in_sala")
public class FilmInSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cinema")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "id_film")
    private Film film;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "prezzo")
    @Check(constraints = "prezzo > 0")
    private Double prezzo;

    @Column(name = "posti_rimanenti")
    @Check(constraints = "posti_rimanenti >=0")
    private Integer postiRimanenti;
}
