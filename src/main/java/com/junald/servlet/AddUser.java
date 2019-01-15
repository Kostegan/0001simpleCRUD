package com.junald.servlet;

import com.junald.dao.UserDAO;
import com.junald.dao.UserDAOImpl;
import com.junald.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUser extends HttpServlet {
    private UserDAO dao;

    public AddUser() {
        dao = new UserDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        user.setLogin(request.getParameter("login"));
        dao.addStudent(user);
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        request.setAttribute("users", dao.getAllStudents());
        view.forward(request, response);
    }
}
