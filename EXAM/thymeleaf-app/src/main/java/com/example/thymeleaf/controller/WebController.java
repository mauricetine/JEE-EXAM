package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Classe;
import com.example.thymeleaf.model.Sector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class WebController {

    private final Map<Long,Sector> sectors = new LinkedHashMap<>();
    private final Map<Long,Classe> classes = new LinkedHashMap<>();

    public WebController() {
        sectors.put(1L, new Sector(1L,"Informatique"));
        sectors.put(2L, new Sector(2L,"Gestion"));

        classes.put(1L, new Classe(1L,"GL","Génie Logiciel",1L));
        classes.put(2L, new Classe(2L,"SIC","Systèmes Informatiques",1L));
        classes.put(3L, new Classe(3L,"MKG","Marketing",2L));
    }

    @GetMapping({"/","/sectors"})
    public String sectors(Model model) {
        model.addAttribute("sectors", sectors.values());
        return "sectors";
    }

    @GetMapping("/sectors/new")
    public String newSectorForm(Model model) {
        model.addAttribute("sector", new Sector());
        return "sector-form";
    }

    @PostMapping("/sectors")
    public String createSector(@ModelAttribute Sector sector) {
        long id = sectors.keySet().stream().max(Long::compare).orElse(0L) + 1;
        sector.setId(id);
        sectors.put(id, sector);
        return "redirect:/sectors";
    }

    @GetMapping("/classes")
    public String classes(Model model) {
        model.addAttribute("classes", classes.values());
        model.addAttribute("sectors", sectors.values());
        return "classes";
    }

    @GetMapping("/classes/new")
    public String newClassForm(Model model) {
        model.addAttribute("classe", new Classe());
        model.addAttribute("sectors", sectors.values());
        return "class-form";
    }

    @PostMapping("/classes")
    public String createClass(@ModelAttribute Classe classe) {
        long id = classes.keySet().stream().max(Long::compare).orElse(0L) + 1;
        classe.setId(id);
        classes.put(id, classe);
        return "redirect:/classes";
    }
}
