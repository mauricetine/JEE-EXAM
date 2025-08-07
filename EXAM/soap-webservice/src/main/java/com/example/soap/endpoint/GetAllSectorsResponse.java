package com.example.soap.endpoint;

import com.example.soap.model.Sector;
import java.util.ArrayList;
import java.util.List;

public class GetAllSectorsResponse {
    private List<Sector> sectors = new ArrayList<>();
    public List<Sector> getSectors() { return sectors; }
    public void setSectors(List<Sector> sectors) { this.sectors = sectors; }
}
