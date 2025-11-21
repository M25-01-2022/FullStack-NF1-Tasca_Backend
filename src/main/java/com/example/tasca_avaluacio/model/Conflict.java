package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table (name = "conflicts")
public class Conflict {
    private enum status{ACTIVE,FROZEN,ENDED}

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private LocalDate startDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private status status; //ACTIVE, FROZEN, ENDED
    @Lob
    private String description;


    //Relacion con muchos paises implicados en conflictos
    @ManyToMany
    @JoinTable(name = "country_conflicts",
            joinColumns = @JoinColumn(name = "conflict_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    private List<Country> countries;

    public Conflict(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public status getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setConflict(List<Country> country) {
        this.countries = country;
    }
}