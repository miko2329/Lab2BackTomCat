package com.example.lab2backtomcat.servlets;

import com.example.lab2backtomcat.classes.Answer;
import com.example.lab2backtomcat.classes.Question;
import com.example.lab2backtomcat.classes.User;
import com.example.lab2backtomcat.db.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Question> questions = DBManager.getAllQuestions();
        int score = 0;
        for (Question q : questions) {
            String userAnswer = request.getParameter("q" + q.getId());
            if (userAnswer != null && userAnswer.equals(q.getCorrectOption())) {
                score++;
            }
        }

        int id = ((User) request.getSession().getAttribute("CURRENT_USER")).getId();

        DBManager.sendAnswer(new Answer(null, score, id));

        String path = "test?score=" + score;

        response.sendRedirect(path);
    }
}
