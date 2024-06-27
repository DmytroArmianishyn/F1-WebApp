package com.example.tpot6web.service;

import com.example.tpot6web.database.HibernateUtil;
import com.example.tpot6web.models.TeamF1;
import org.hibernate.Session;

import java.util.List;

public class TeamService {

    public List<TeamF1> getAllTeams() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TeamF1", TeamF1.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
