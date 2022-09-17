package com.example.demojsp.controller.category;

import com.example.demojsp.dao.CategoryDao;
import com.example.demojsp.model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetListCategory", value = "/GetListCategory")
public class GetListCategory extends HttpServlet {
//    public CategoryDao categoryDao;

//    GetListCategory() {
//        super();
//       categoryDao = new CategoryDao();
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        CategoryDao categoryDao = new CategoryDao();
//        List<Category> categories = categoryDao.findAll();
//        request.setAttribute("categories", categories);
//        request.getRequestDispatcher("create-ticket.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append( request.getParameter("data"));
    }
}
