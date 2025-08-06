package com.example.soap.endpoint;

import com.example.soap.model.Classe;
import java.util.ArrayList;
import java.util.List;

public class GetClassesBySectorIdResponse {
    private List<Classe> classes = new ArrayList<>();
    public List<Classe> getClasses() { return classes; }
    public void setClasses(List<Classe> classes) { this.classes = classes; }
}
