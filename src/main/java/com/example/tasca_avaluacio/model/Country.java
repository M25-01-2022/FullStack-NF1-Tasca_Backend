package com.example.tasca_avaluacio.model;

import jakarta.persistence.*;
import java.util.*;

@Table(name="countries")
public class Country {

    //Datos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, length = 5)
    private String code;


    public Country() {}
    public Country(String name, String code) {
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
