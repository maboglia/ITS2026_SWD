package com.mombelli.pokemon.repository;

import com.mombelli.pokemon.entity.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Data-access layer for {@link Pokemon}.
 * Contains both the individual finders requested by the exercise and a single
 * flexible query used by the service for the (type + search + pagination) screen.
 */
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    /** All pokémon ordered by name (derived query). */
    List<Pokemon> findAllByOrderByNameAsc();

    /** All pokémon whose primary type matches. */
    List<Pokemon> findByType1IgnoreCaseOrderByNameAsc(String type1);

    /** All pokémon whose secondary type matches. */
    List<Pokemon> findByType2IgnoreCaseOrderByNameAsc(String type2);

    /** All pokémon where the given type appears as either type1 OR type2 (JPQL). */
    @Query("""
            SELECT p FROM Pokemon p
            WHERE LOWER(p.type1) = LOWER(:type) OR LOWER(p.type2) = LOWER(:type)
            ORDER BY p.name ASC
            """)
    List<Pokemon> findByEitherType(@Param("type") String type);

    /**
     * Distinct list of every type used, taken from BOTH columns via an HQL set
     * operation (supported by Hibernate 6+). Empty second-type values are excluded.
     * Final alphabetical sorting is applied in the service.
     */
    @Query("""
            SELECT DISTINCT p.type1 FROM Pokemon p WHERE p.type1 IS NOT NULL AND p.type1 <> ''
            UNION
            SELECT DISTINCT p.type2 FROM Pokemon p WHERE p.type2 IS NOT NULL AND p.type2 <> ''
            """)
    List<String> findDistinctTypes();

    /**
     * Combined, paginated query powering the home page: optional type filter
     * (matches either column) and optional case-insensitive name search.
     * Passing {@code null} disables the corresponding filter.
     */
    @Query("""
            SELECT p FROM Pokemon p
            WHERE (:type IS NULL OR LOWER(p.type1) = LOWER(:type) OR LOWER(p.type2) = LOWER(:type))
              AND (:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))
            """)
    Page<Pokemon> search(@Param("type") String type, @Param("name") String name, Pageable pageable);
}
