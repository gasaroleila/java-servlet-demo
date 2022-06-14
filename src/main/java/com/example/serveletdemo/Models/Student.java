package com.example.serveletdemo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Column(name = "names", nullable = false)
    private String Names;
    @Id
    private Long id;

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
