package com.junald.servlet;

import com.junald.model.User;
import com.junald.model.User;
import com.junald.services.DBService;
import com.junald.services.DBServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditUserServlet extends HttpServlet {
    private DBService dbService = DBServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = new User(
                id,
                request.getParameter("name"),
                request.getParameter("password"),
                request.getParameter("login"));
        dbService.updateUser(user);
        response.sendRedirect("/users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher view = request.getRequestDispatcher("editUser.jsp");
        request.setAttribute("user", dbService.getUserById(id));
        view.forward(request, response);
    }
}
