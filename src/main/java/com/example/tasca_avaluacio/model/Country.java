package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;
import java.util.*;

@Table(name="countries")
public class Country {

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "country", nullable = false)
    private String name;
    @Column(nullable = false)
    private String code;

    //Relacion de un pais con muchos conflictos
     @OneToMany(
             mappedBy = "country",
             cascade = CascadeType.ALL,
             orphanRemoval = true,
             fetch = FetchType.LAZY
     )
     List<Conflict> conflicts;

     public void addConflict(Conflict conflict){
         conflicts.add(conflict);
         conflict.setConflict(this);
     }

     //Relacion de un pais con muchos aliados
    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
     @JoinTable(name = "support_countries",
             joinColumns = @JoinColumn(name = "conflict_id"),
             inverseJoinColumns = @JoinColumn(name = "country_id")
     )
     List<Faction> factions;

     public void addFactions(Faction faction){
         factions.add(faction);
         faction.setFaction(this);
     }

    protected Country() {}
    public Country(long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString(){
        return String.format("Country[id=%d, name='%s', code='%s]",
                id, name, code);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
