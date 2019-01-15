package com.junald.servlet;

import com.junald.dao.UserDAO;
import com.junald.dao.UserDAOImpl;
import com.junald.model.Student;

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
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setPassword(request.getParameter("password"));
        student.setLogin(request.getParameter("login"));
        dao.addStudent(student);
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        request.setAttribute("users", dao.getAllStudents());
        view.forward(request, response);
    }
}
