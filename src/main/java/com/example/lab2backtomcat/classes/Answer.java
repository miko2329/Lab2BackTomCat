package com.example.lab2backtomcat.classes;

public class Answer {
    private Integer id;
    private int correctAnswer;
    private int userId;

    public Answer() {
    }

    public Answer(Integer id, int correctAnswer, int userId) {
        this.id = id;
        this.correctAnswer = correctAnswer;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
