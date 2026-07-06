package com.mombelli.cinema.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prenotazioni")
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_film_in_sala")
    private FilmInSala filmInSala;

    @Column(name = "nome")
    private String nome;

    @Column(name = "posti_prenotati")
    @Check(constraints = "posti_prenotati >=0")
    private Integer postiPrenotati;
}
