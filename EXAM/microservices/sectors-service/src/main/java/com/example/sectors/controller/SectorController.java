package com.example.sectors.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final Map<Long,String> sectors = new LinkedHashMap<>();

    public SectorController() {
        sectors.put(1L, "Informatique");
        sectors.put(2L, "Gestion");
    }

    @GetMapping
    public List<Map<String,Object>> all() {
        List<Map<String,Object>> list = new ArrayList<>();
        sectors.forEach((k,v) -> {
            Map<String,Object> m = new HashMap<>();
            m.put("id", k);
            m.put("name", v);
            list.add(m);
        });
        return list;
    }

    @PostMapping
    public Map<String,Object> create(@RequestBody Map<String,String> body) {
        long id = sectors.keySet().stream().max(Long::compare).orElse(0L) + 1;
        sectors.put(id, body.get("name"));
        Map<String,Object> resp = new HashMap<>();
        resp.put("id", id);
        resp.put("name", body.get("name"));
        return resp;
    }
}
