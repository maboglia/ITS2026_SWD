package com.boglia.pokemon.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "POKEMON")
public class Pokemon {

    @Id
    private int id;
    private String name;
    private String type1;
    private String type2;

}
