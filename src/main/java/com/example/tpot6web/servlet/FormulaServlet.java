package com.example.tpot6web.servlet;

import com.example.tpot6web.service.RacerService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "f1", value = "/first")
public class FormulaServlet extends HttpServlet {

    RacerService service = new RacerService();

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
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + "F1 Servlet" + "</h1>");
        out.write("<h1>" + "F1 Servlets" + "</h1>");


        if (req.getParameter("showTeams") != null) {
            req.setAttribute("showTeams", true);
        } else {
            req.setAttribute("showTeams", false);
        }
        req.setAttribute("service", service);
        req.getRequestDispatcher("D:\\Java\\TPO\\TpoT6Web\\src\\main\\webapp\\index.jsp").forward(req, resp);

    }
}
