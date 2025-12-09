package com.example.tasca_avaluacio.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ConflictDTO {
    private Long id;
    private String name;
    private LocalDateTime startdate;
    private String status;
    private String description;
    private List<String> countries;

    public ConflictDTO(Long id, String name, LocalDateTime startdate, String status, String description, List<String> countries) {
        this.id = id;
        this.name = name;
        this.startdate = startdate;
        this.status = status;
        this.description = description;
        this.countries = countries;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartdate() {
        return startdate;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCountries() {
        return countries;
    }
}