package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "conflicts")
public class Conflict {
    private enum stat{ACTIVE,FROZEN,ENDED}

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    private LocalDate startDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private stat status; //ACTIVE, FROZEN, ENDED
    @Lob
    private String description;


    //Relacion con muchos paises implicados en conflictos
    @ManyToMany
    @JoinTable(name = "country_conflicts",
            joinColumns = @JoinColumn(name = "conflict_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private Country countries;

    public Country getCountries() {
        return countries;
    }

    public void setConflict(Country country) {
        this.countries = country;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public stat getStatus() {
        return status;
    }

    public void setStatus(stat status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}