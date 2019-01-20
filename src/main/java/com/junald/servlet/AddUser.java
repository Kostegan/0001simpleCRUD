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

@WebServlet("/add")
public class AddUser extends HttpServlet {
    private DBService dbService = DBServiceImpl.getInstance();

    public AddUser() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDataSet userDataSet = new UserDataSet();
        userDataSet.setName(request.getParameter("name"));
        userDataSet.setPassword(request.getParameter("password"));
        userDataSet.setLogin(request.getParameter("login"));
        dbService.addUser(userDataSet);
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        request.setAttribute("users", dbService.getAllUsers());
        view.forward(request, response);
    }
}
