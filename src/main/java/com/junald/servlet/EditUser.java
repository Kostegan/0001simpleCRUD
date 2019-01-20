package com.junald.servlet;

import com.junald.model.UserDataSet;
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
public class EditUser extends HttpServlet {
    private DBService dbService = DBServiceImpl.getInstance();
    private UserDataSet userDataSet;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDataSet.setName(request.getParameter("name"));
        userDataSet.setPassword(request.getParameter("password"));
        userDataSet.setLogin(request.getParameter("login"));
        dbService.updateUser(userDataSet);
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        request.setAttribute("users", dbService.getAllUsers());
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDataSet = dbService.getUserById(Integer.parseInt(request.getParameter("userId")));
        RequestDispatcher view = request.getRequestDispatcher("editUser.jsp");
        request.setAttribute("users", userDataSet);
        view.forward(request, response);
    }
}
