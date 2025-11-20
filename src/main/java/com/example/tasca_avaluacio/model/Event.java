package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100)
    private LocalDate eventDate = LocalDate.now();
    @Column(nullable = false)
    private String location;
    @Lob
    private String description;

    public Long getId() {
        return id;
    }




    public LocalDate getEventDate() {
        return eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}