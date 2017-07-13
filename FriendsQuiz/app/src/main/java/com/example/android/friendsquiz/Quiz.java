package com.example.android.friendsquiz;

import android.widget.TextView;

import java.util.List;

public class Quiz {

    private TextView question;

    private List<String> answer;

    private int templateId;

    private List<String> correctAnswers;

    public Quiz(TextView question, List<String> answer, List<String> correctAnswers, int templateId) {
        this.question = question;
        this.answer = answer;
        this.correctAnswers = correctAnswers;
        this.templateId = templateId;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return (answer.toString().equals(correctAnswers.toString()));
    }

}
