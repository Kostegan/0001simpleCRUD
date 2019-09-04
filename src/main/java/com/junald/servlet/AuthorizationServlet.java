package com.junald.servlet;

import com.junald.model.Role;
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

@WebServlet("/Authorization")
public class AuthorizationServlet extends HttpServlet {
    private DBService dbService = DBServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int id = dbService.getUserId(login);
        if (id != -1) {
            User user = dbService.getUserById(id);
            if (password.endsWith(user.getPassword())) {
                req.getSession().setAttribute("startUser", user);
                if (user.getRole() == Role.admin) {
                    resp.sendRedirect("/admin");
                } else {
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("user.jsp");
                    requestDispatcher.forward(req, resp);
                }
            }
        } else {
            resp.sendError(401, "Login or password is invalid.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user.jsp");
        requestDispatcher.forward(req, resp);
    }
}
