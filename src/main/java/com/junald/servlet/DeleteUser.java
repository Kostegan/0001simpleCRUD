package com.junald.servlet;

import com.junald.dao.UserDAO;
import com.junald.dao.UserDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet {
    private UserDAO dao;

    public DeleteUser() {
        dao = new UserDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao.deleteStudent(Integer.parseInt(request.getParameter("userId")));
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        request.setAttribute("users", dao.getAllStudents());
        view.forward(request, response);
    }
}
