package com.example.thymeleaf.model;

public class Sector {
    private Long id;
    private String name;
    public Sector() {}
    public Sector(Long id, String name) { this.id = id; this.name = name; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
