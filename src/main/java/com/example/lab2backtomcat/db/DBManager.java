package com.example.lab2backtomcat.db;

import com.example.lab2backtomcat.classes.Answer;
import com.example.lab2backtomcat.classes.Question;
import com.example.lab2backtomcat.classes.User;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    private static final String URL = "jdbc:postgresql://localhost/TestDB";
    private static final String USER = "postgres";
    private static final String PASSWORD = "72740304w";

    private static Connection connection;

    static{
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to DB");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean addUser(User user){
        boolean isSuccessful = false;

        try {

            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Users\" (\n" +
                    "privilege, login, password) VALUES (\n" +
                    "'default', ?, ?);");

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.executeUpdate();

            isSuccessful = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }

    public static User getUser(User user){
        User result = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Users\"\n" +
                    "WHERE login = ? AND password = ?;");

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            ResultSet set = statement.executeQuery();

            while(set.next()){
                result = new User(
                        set.getInt("id"),
                        set.getString("privilege"),
                        set.getString("login"),
                        set.getString("password")
                );
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ArrayList<Question> getAllQuestions(){
        ArrayList<Question> questions = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.\"Questions\"\n" +
                    "ORDER BY id ASC");

            ResultSet set = statement.executeQuery();

            questions = new ArrayList<>();

            while(set.next()){
                questions.add(new Question(
                        set.getInt("id"),
                        set.getString("question"),
                        set.getString("optionA"),
                        set.getString("optionB"),
                        set.getString("optionC"),
                        set.getString("correctOption")
                ));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }

    public static boolean sendAnswer(Answer answer){
        boolean isSuccessful = false;

        try{

            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Answers\" (\n" +
                    "\"correctAnswers\", \"userId\") VALUES (\n" +
                    "?, ?);");

            statement.setInt(1, answer.getCorrectAnswer());
            statement.setInt(2, answer.getUserId());

            statement.executeUpdate();

            isSuccessful = true;

        } catch (Exception e){
            e.printStackTrace();
        }


        return isSuccessful;
    }

    public static ArrayList<Integer> getX(){
        ArrayList<Integer> x = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT \"correctAnswers\", COUNT(*) as count \n" +
                    "FROM public.\"Answers\" GROUP BY \"correctAnswers\";");

            ResultSet set = statement.executeQuery();

            x = new ArrayList<>();

            while(set.next()){
                x.add(set.getInt("correctAnswers"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return x;
    }

    public static ArrayList<Integer> getY(){
        ArrayList<Integer> y = null;

        try {

            PreparedStatement statement = connection.prepareStatement("SELECT \"correctAnswers\", COUNT(*) as count \n" +
                    "FROM public.\"Answers\" GROUP BY \"correctAnswers\";");

            ResultSet set = statement.executeQuery();

            y = new ArrayList<>();

            while(set.next()){
                y.add(set.getInt("count"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return y;
    }

    public static boolean addQuestion(Question question){
        boolean isSuccessful = false;

        try{

            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.\"Questions\" (\n" +
                    "question, \"optionA\", \"optionB\", \"optionC\", \"correctOption\") VALUES (\n" +
                    "?, ?, ?, ?, ?);");

            statement.setString(1, question.getQuestionText());
            statement.setString(2, question.getOptionA());
            statement.setString(3, question.getOptionB());
            statement.setString(4, question.getOptionC());
            statement.setString(5, question.getCorrectOption());

            statement.executeUpdate();

            isSuccessful = true;

        } catch (Exception e){
            e.printStackTrace();
        }

        return isSuccessful;
    }
}
