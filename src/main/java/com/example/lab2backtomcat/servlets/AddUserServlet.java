package com.example.lab2backtomcat.servlets;

import com.example.lab2backtomcat.db.DBManager;
import com.example.lab2backtomcat.classes.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = (String) request.getParameter("login");
        String password = (String) request.getParameter("password");

        User user = new User(null, "default", login, password);

        User exist = DBManager.getUser(user);

        if(exist==null){
            DBManager.addUser(user);
            response.sendRedirect("register?success");
        }

    }
}
