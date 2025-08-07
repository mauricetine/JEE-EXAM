
package com.example.building.web;

import com.example.building.dao.BuildingDAO;
import com.example.building.entities.Building;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BuildingServlet extends HttpServlet {
    private EntityManagerFactory emf;

    public void init() {
        emf = Persistence.createEntityManagerFactory("buildingPU");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = emf.createEntityManager();
        BuildingDAO dao = new BuildingDAO(em);
        List<Building> buildings = dao.findAll();
        request.setAttribute("buildings", buildings);
        request.getRequestDispatcher("/jsp/listBuildings.jsp").forward(request, response);
        em.close();
    }
}
