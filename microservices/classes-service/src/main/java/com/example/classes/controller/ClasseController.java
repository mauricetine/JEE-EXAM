package com.example.classes.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    private final List<Map<String,Object>> classes = new ArrayList<>();

    public ClasseController() {
        classes.add(Map.of("id",1L,"className","GL","description","Génie Logiciel","sectorId",1L));
        classes.add(Map.of("id",2L,"className","SIC","description","Systèmes Informatiques","sectorId",1L));
        classes.add(Map.of("id",3L,"className","MKG","description","Marketing","sectorId",2L));
    }

    @GetMapping
    public List<Map<String,Object>> all() { return classes; }

    @GetMapping("/bySector/{sectorId}")
    public List<Map<String,Object>> bySector(@PathVariable Long sectorId) {
        List<Map<String,Object>> out = new ArrayList<>();
        for (Map<String,Object> c: classes) {
            if (Objects.equals(((Number)c.get("sectorId")).longValue(), sectorId)) out.add(c);
        }
        return out;
    }

    @PostMapping
    public Map<String,Object> create(@RequestBody Map<String,Object> body) {
        long next = classes.stream().mapToLong(c -> ((Number)c.get("id")).longValue()).max().orElse(0L) + 1L;
        Map<String,Object> entry = new HashMap<>(body);
        entry.put("id", next);
        classes.add(entry);
        return entry;
    }
}
