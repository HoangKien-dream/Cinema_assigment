package com.example.demojsp.controller.ticket;

import com.example.demojsp.dao.CinemaDao;
import com.example.demojsp.dao.MovieDao;
import com.example.demojsp.dao.RoomDao;
import com.example.demojsp.dao.TicketDao;
import com.example.demojsp.model.Cinema;
import com.example.demojsp.model.Movie;
import com.example.demojsp.model.Room;
import com.example.demojsp.model.Ticket;
import com.example.demojsp.util.DateTimeUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "CreateTicket", value = "/CreateTicket")
public class CreateTicket extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CinemaDao cinemaDao = new CinemaDao();
        List<Cinema> cinemas = cinemaDao.findAll();
        request.setAttribute("cinemas", cinemas);
        MovieDao movieDao = new MovieDao();
        List<Movie> movies = movieDao.getAll();
        request.setAttribute("movies", movies);
        RoomDao roomDao = new RoomDao();
        List<Room> rooms = roomDao.findAll();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("create-ticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ticket ticket = new Ticket();
        ticket.setPrice(Double.parseDouble(request.getParameter("price")));
        ticket.setMovieId(Integer.parseInt(request.getParameter("movieId")));
        ticket.setRoomId(Integer.parseInt(request.getParameter("roomId")));
        ticket.setTime(Time.valueOf(request.getParameter("time")));
        ticket.setDate(DateTimeUtils.parseDateFromString(request.getParameter("date")));
        if (Objects.nonNull(ticket)){
            TicketDao ticketDao = new TicketDao();
            ticketDao.createTicket(ticket,20);
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Tạo vé thành công');");
            out.println("location='http://localhost:8081/cinema_master_war_exploded/GetListMovie';");
            out.println("</script>");
        }
    }
}
