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

@WebServlet("/edit")
public class EditUser extends HttpServlet {
    private UserDAO dao;
    private Student student;

    public EditUser() {
        dao = new UserDAOImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        student.setName(request.getParameter("name"));
        student.setPassword(request.getParameter("password"));
        student.setLogin(request.getParameter("login"));
        dao.updateStudent(student);
        RequestDispatcher view = request.getRequestDispatcher("listUsers.jsp");
        request.setAttribute("users", dao.getAllStudents());
        view.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        student = dao.getStudentById(Integer.parseInt(request.getParameter("userId")));
        RequestDispatcher view = request.getRequestDispatcher("editUser.jsp");
        request.setAttribute("users", student);
        view.forward(request, response);
    }
}
