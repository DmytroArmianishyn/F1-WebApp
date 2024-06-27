package com.example.tpot6web.servlet;

import java.io.*;
import java.util.List;

import com.example.tpot6web.models.Racer;
import com.example.tpot6web.service.RacerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {

    }

    RacerService service = new RacerService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String age = request.getParameter("id");
        String name = request.getParameter("name");
        String team = request.getParameter("team");
        String points = request.getParameter("points");
        String engine = request.getParameter("engine");
        String start = request.getParameter("from");
        String end = request.getParameter("to");
        List<Racer> racers = null;
        racers= service.getForTeam(name,age,team,points,engine,start,end);
        request.setAttribute("Racers", racers);
        request.getRequestDispatcher("/teams.jsp").forward(request, response);
    }

    public void destroy() {
    }
}