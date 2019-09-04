package com.junald.servlet;

import com.junald.model.Role;
import com.junald.model.User;
import com.junald.services.DBService;
import com.junald.services.DBServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    private DBService dbService = DBServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setLogin(request.getParameter("login"));
        user.setRole(Role.valueOf(request.getParameter("role")));
        dbService.addUser(user);
        response.sendRedirect("/admin");
    }
}
