package com.example.tasca_avaluacio.dto;

import java.time.LocalDate;
import java.util.List;

public class CreateConflictDTO {
    private String name;
    private String status;
    private String description;
    private LocalDate startDate;
    private List<Long> countryIds;

    public CreateConflictDTO() {}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public List<Long> getCountryIds() {
        return countryIds;
    }
    public void setCountryIds(List<Long> countryIds) {
        this.countryIds = countryIds;
    }
}