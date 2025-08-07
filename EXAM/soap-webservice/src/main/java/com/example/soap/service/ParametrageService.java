package com.example.soap.service;

import com.example.soap.model.Classe;
import com.example.soap.model.Sector;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParametrageService {
    private final List<Sector> sectors = new ArrayList<>();
    private final List<Classe> classes = new ArrayList<>();

    @PostConstruct
    public void init() {
        sectors.add(new Sector(1L, "Informatique"));
        sectors.add(new Sector(2L, "Gestion"));

        classes.add(new Classe(1L, "GL", "Génie Logiciel", 1L));
        classes.add(new Classe(2L, "SIC", "Systèmes Informatiques", 1L));
        classes.add(new Classe(3L, "MKG", "Marketing", 2L));
    }

    public List<Sector> getAllSectors() { return sectors; }

    public List<Classe> getClassesBySectorId(Long sectorId) {
        return classes.stream().filter(c -> c.getSectorId().equals(sectorId)).collect(Collectors.toList());
    }
}
