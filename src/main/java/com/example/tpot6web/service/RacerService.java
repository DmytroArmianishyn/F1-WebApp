package com.example.tpot6web.service;

import com.example.tpot6web.database.HibernateUtil;
import com.example.tpot6web.models.Racer;
import com.example.tpot6web.models.TeamF1;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacerService {




    public RacerService() {

    }
    public List<Racer> getAllRacers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Racer", Racer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Racer getRacers(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Racer racer = session.get(Racer.class,id);
            return racer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





  public List<Racer> getForTeam(String name,String age,String teamName,String points,String engine,String start,String end) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            StringBuilder query = new StringBuilder("select r from Racer r join r.teams t join t.bolids b where 1=1 ");
            Map<String, Object> parameters = new HashMap<>();

            if (name != null && !name.isEmpty()) {
                query.append("and r.fullName = :name ");
                parameters.put("name", name);
            }
            if (age != null && !age.isEmpty()) {
                query.append("and r.age = :age ");
                parameters.put("age", Integer.parseInt(age));
            }
            if (teamName != null && !teamName.isEmpty()) {
                query.append("and t.name = :teamName ");
                parameters.put("teamName", teamName);
            }
            if (points != null && !points.isEmpty()) {
                query.append("and r.points = :points ");
                parameters.put("points", Integer.parseInt(points));
            }
            if (engine != null && !engine.isEmpty()) {
                query.append("and b.engine  = :engine ");
                parameters.put("engine", engine);
            }
            query.append("order by r.points desc");
            Query<Racer> selectQuery = session.createQuery(query.toString(), Racer.class);
            for (Map.Entry<String,Object> entry:parameters.entrySet()) {
                selectQuery.setParameter(entry.getKey(),entry.getValue());
            }
            if (start!=null&&!start.isEmpty()&&end!=null&&!end.isEmpty()){
                selectQuery.setFirstResult(Integer.parseInt(start)-1);
                selectQuery.setMaxResults(Integer.parseInt(end));
            }
            return selectQuery.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}
