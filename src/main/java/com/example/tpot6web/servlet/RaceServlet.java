package com.example.tpot6web.servlet;

import com.example.tpot6web.models.Race;
import com.example.tpot6web.service.RaceService;
import com.example.tpot6web.service.RacerService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "race-servlet" ,value = "/race")
public class RaceServlet extends HttpServlet {


    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameRace = req.getParameter("name");
         String fullName = req.getParameter("racer");
         String place = req.getParameter("place");
        String city = req.getParameter("city");
         RaceService service = new RaceService();

        service.checkRaceParametr(nameRace,city);
         if (service.checkParam(nameRace,fullName,place)){
                service.addPoints(fullName,nameRace,place);
         }
        String gearbox = req.getParameter("gearbox");
        String telemetryEquipment = req.getParameter("telemetry_equipment");
        String engine = req.getParameter("engine");
        String teamName = req.getParameter("team_name");

        if (teamName!=null&&!teamName.isEmpty()) {
            service.updateDetails(gearbox, telemetryEquipment, engine, teamName);
        }





     req.getRequestDispatcher("/race.jsp").forward(req, resp);


    }


}
