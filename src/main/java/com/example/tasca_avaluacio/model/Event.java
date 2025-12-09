package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
public class Event {

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate eventDate = LocalDate.now();
    @Column(nullable = false)
    private String location;
    @Lob
    private String description;

    // Relacion por cada evento pertenece a un conflicto
    @ManyToOne
    @JoinColumn(name = "conflict_id", nullable = false)
    private Conflict conflict;

    public Event(){}

    public Long getId() {
        return id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Conflict getConflict() {
        return conflict;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }
}