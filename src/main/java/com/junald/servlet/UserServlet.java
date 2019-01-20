package com.junald.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junald.model.UserDataSet;
import com.junald.services.DBService;
import com.junald.services.DBServiceImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private DBService dbService = DBServiceImpl.getInstance();

    public UserServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        List<UserDataSet> list = dbService.getAllUsers();
        request.setAttribute("users", list);
        view.forward(request, response);
    }
}
