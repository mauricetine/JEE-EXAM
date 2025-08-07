
package com.example.building.dao;

import com.example.building.entities.Building;
import javax.persistence.*;
import java.util.List;

public class BuildingDAO {
    private EntityManager em;

    public BuildingDAO(EntityManager em) {
        this.em = em;
    }

    public void create(Building building) {
        em.getTransaction().begin();
        em.persist(building);
        em.getTransaction().commit();
    }

    public List<Building> findAll() {
        return em.createQuery("SELECT b FROM Building b", Building.class).getResultList();
    }
}
