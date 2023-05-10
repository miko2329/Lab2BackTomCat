package com.example.lab2backtomcat.servlets;

import com.example.lab2backtomcat.classes.Question;
import com.example.lab2backtomcat.db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/addQ")
public class AddQServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = (String) request.getParameter("questionText");
        String optionA = (String) request.getParameter("optionA");
        String optionB = (String) request.getParameter("optionB");
        String optionC = (String) request.getParameter("optionC");
        String correctOption = (String) request.getParameter("correctOption");

        Question question = new Question(null, text, optionA, optionB, optionC, correctOption);

        if(DBManager.addQuestion(question)){
            response.sendRedirect("addQuestion?success");
        }

    }
}
