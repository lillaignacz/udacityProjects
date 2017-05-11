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

    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    public TextView getQuestion() {
        return question;
    }

    public void setQuestion(TextView question) {
        this.question = question;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public List<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(List<String> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public boolean isCorrect(){
        if (answer.toString().equals(correctAnswers.toString())) {
            return true;
        }
        else
            return false;
    }

}
