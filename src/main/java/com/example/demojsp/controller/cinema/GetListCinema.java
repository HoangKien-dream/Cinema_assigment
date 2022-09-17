package com.example.demojsp.controller.cinema;

import com.example.demojsp.dao.CinemaDao;
import com.example.demojsp.model.Cinema;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListCinema", value = "/GetListCinema")
public class GetListCinema extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CinemaDao cinemaDao = new CinemaDao();
        List<Cinema> cinemas = cinemaDao.findAll();
        request.setAttribute("cinemas", cinemas);
        request.getRequestDispatcher("create-ticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
