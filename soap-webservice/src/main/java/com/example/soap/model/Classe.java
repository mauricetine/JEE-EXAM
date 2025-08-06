package com.example.soap.model;

public class Classe {
    private Long id;
    private String className;
    private String description;
    private Long sectorId;

    public Classe() {}
    public Classe(Long id, String className, String description, Long sectorId) {
        this.id = id; this.className = className; this.description = description; this.sectorId = sectorId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Long getSectorId() { return sectorId; }
    public void setSectorId(Long sectorId) { this.sectorId = sectorId; }
}
