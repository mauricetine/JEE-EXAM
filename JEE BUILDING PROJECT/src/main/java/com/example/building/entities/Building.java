
package com.example.building.entities;

import javax.persistence.*;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private int units;

    // Getters and Setters
}
