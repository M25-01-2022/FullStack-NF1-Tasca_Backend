package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Faction {

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;

    // Relacion cada faccion pertenece a único conflicto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conflict_id")
    private Conflict conflict;

    // Relacion con paises que apoyan la faccion
    @ManyToMany
    @JoinTable(
            name = "faction_countries",
            joinColumns = @JoinColumn(name = "faction_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Country countries;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Conflict getConflict() {
        return conflict;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }

    public Country getCountries() {
        return countries;
    }

    public void setFaction(Country country) {
        this.countries = country;
    }
}