package com.example.demojsp.controller.movie;

import com.example.demojsp.dao.CategoryDao;
import com.example.demojsp.dao.MovieDao;
import com.example.demojsp.model.Category;
import com.example.demojsp.model.Movie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListMovie", value = "/GetListMovie")
public class GetListMovie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDao movieDao = new MovieDao();
        List<Movie> movies = movieDao.getAll();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("list-movie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
