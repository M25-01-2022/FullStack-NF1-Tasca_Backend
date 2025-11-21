package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "factions")
public class Faction {

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    // Relacion cada faccion pertenece a único conflicto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conflict_id", nullable = false)
    private Conflict conflict;

    // Relacion con paises que apoyan la faccion
    @ManyToMany
    @JoinTable(
            name = "faction_countries",
            joinColumns = @JoinColumn(name = "faction_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries;

    public Faction(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Conflict getConflict() {
        return conflict;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}