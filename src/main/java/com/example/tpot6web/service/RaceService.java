package com.example.tpot6web.service;

import com.example.tpot6web.database.HibernateUtil;
import com.example.tpot6web.models.*;
import org.hibernate.Session;


import java.util.List;

public class RaceService {

    public boolean checkParam(String race,String racer , String place){
        if (race!=null&&!race.isEmpty()){
            if (racer!=null&&!racer.isEmpty()){
                if (place!=null&&!place.isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }

    public void addPoints(String fullname,String raceName,String place){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Racer racer = session.createQuery(" from Racer  where fullname=:fullname", Racer.class)
                    .setParameter("fullname",fullname)
                    .uniqueResult();


            Race race = session.createQuery(" from Race  where name=:raceName", Race.class)
                    .setParameter("raceName",raceName)
                    .uniqueResult();


            int position = Integer.parseInt(place);

            if (race != null && racer != null) {

                RaceRacer raceService = new RaceRacer(race,racer,position);
                session.save(raceService);

                if (position<11){
                    int points = racer.getPoints();
                    racer.setPoints(points+convertPoints(position));
                    session.update(race);
                }
            }
            session.getTransaction().commit();
        }
    }

    public int convertPoints(int position){

        switch (position){
            case 10 :
                return 1;
            case 9 :
                return 2;
            case 8 :
                return 4;
            case 7 :
                return 6;
            case 6 :
                return 8;
            case 5 :
                return 10;
            case 4 :
                return 12;
            case 3 :
                return 15;
            case 2 :
                return 18;
            case 1 :
                return 25;
        }
        return 0;
    }

    public void addRace(String name,String city){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Race race = session.createQuery("From Race where name=:name", Race.class).setParameter("name",name).uniqueResult();
            if (race==null){
                Race newRace = new Race(name,city);
                session.beginTransaction();
                session.save(newRace);
                session.getTransaction().commit();
            }


        }

    }

    public void checkRaceParametr(String name,String city){
        if (name!=null&&!name.isEmpty()){
            if (city!=null&&!city.isEmpty()){
                    addRace(name,city);
            }
        }

    }

    public void updateDetails( String gearbox,String telemetryEquipment,String engine, String teamName){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
              Bolid bolid = session.createQuery("from Bolid where teamF1.name=:teamName", Bolid.class).setParameter("teamName",teamName).uniqueResult();

            session.beginTransaction();
            if (gearbox!=null&&!gearbox.isEmpty()) {
                bolid.setGearbox(gearbox);
            }
            if (telemetryEquipment!=null&&!telemetryEquipment.isEmpty()) {
                bolid.setTelemetry_equipment(telemetryEquipment);
            }
            if (engine!=null&&!engine.isEmpty()) {
                bolid.setEngine(engine);
            }
            session.save(bolid);
            session.getTransaction().commit();
        }

    }
}
