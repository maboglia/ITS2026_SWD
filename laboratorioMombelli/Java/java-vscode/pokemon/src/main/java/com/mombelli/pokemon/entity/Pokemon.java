package com.mombelli.pokemon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * JPA entity mapped to the existing {@code pokemon} table.
 * <p>
 * The physical columns contain spaces (e.g. {@code "Type 1"}), so every field is
 * mapped explicitly with {@link Column}. The table is managed externally, therefore
 * {@code ddl-auto=none} is configured and this entity is read-only in practice.
 */
@Entity
@Table(name = "pokemon")
@Getter
@Setter
public class Pokemon {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "Pokedex Number")
    private Integer pokedexNumber;

    @Column(name = "Name")
    private String name;

    @Column(name = "Type 1")
    private String type1;

    @Column(name = "Type 2")
    private String type2;

    @Column(name = "Total")
    private Integer total;

    @Column(name = "HP")
    private Integer hp;

    @Column(name = "Attack")
    private Integer attack;

    @Column(name = "Defense")
    private Integer defense;

    @Column(name = "Sp Atk")
    private Integer spAtk;

    @Column(name = "Sp Def")
    private Integer spDef;

    @Column(name = "Speed")
    private Integer speed;

    @Column(name = "Generation")
    private Integer generation;

    /** Stored as the string {@code "True"} / {@code "False"} in the database. */
    @Column(name = "Legendary")
    private String legendary;

    /** Convenience flag so templates can use {@code pokemon.legendaryFlag}. */
    public boolean isLegendaryFlag() {
        return "True".equalsIgnoreCase(legendary);
    }

    /** True when the pokémon has a real second type (the column may hold an empty string). */
    public boolean hasType2() {
        return type2 != null && !type2.isBlank();
    }

    // ---------------------------------------------------------------------
    // Image slug logic — ported from the original PHP model. The stored names
    // are mangled (e.g. "VenusaurMega Venusaur", "CharizardMega Charizard X"),
    // so we derive a clean pokemondb.net slug from them.
    // ---------------------------------------------------------------------

    /** First token of the name, e.g. {@code "VenusaurMega"} from {@code "VenusaurMega Venusaur"}. */
    private String firstPart() {
        if (name == null || name.isBlank()) {
            return "";
        }
        return name.trim().split(" ")[0];
    }

    /** Base species slug: first token, trailing "Mega" stripped, lower-cased. */
    public String baseSlug() {
        return firstPart().replaceFirst("Mega$", "").toLowerCase();
    }

    /** True when the name denotes a Mega evolution form. */
    public boolean isMega() {
        return firstPart().endsWith("Mega");
    }

    /**
     * Full pokemondb.net artwork slug, adding the {@code -mega}, {@code -mega-x}
     * or {@code -mega-y} suffix for Mega forms (mirrors the PHP getImagineUrlMega).
     */
    public String artworkSlug() {
        String slug = baseSlug();
        if (isMega()) {
            if (name.endsWith(" X")) {
                slug += "-mega-x";
            } else if (name.endsWith(" Y")) {
                slug += "-mega-y";
            } else {
                slug += "-mega";
            }
        }
        return slug;
    }

    /** Large artwork URL served directly by pokemondb.net. */
    public String getImageUrl() {
        return "https://img.pokemondb.net/artwork/large/" + artworkSlug() + ".jpg";
    }
}
