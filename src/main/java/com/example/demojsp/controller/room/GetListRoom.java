package com.example.demojsp.controller.room;

import com.example.demojsp.dao.RoomDao;
import com.example.demojsp.model.Room;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListRoom", value = "/GetListRoom")
public class GetListRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomDao roomDao = new RoomDao();
        List<Room> rooms = roomDao.findAll();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("create-ticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
