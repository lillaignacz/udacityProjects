package com.example.android.friendsquiz;

import java.util.List;

/**
 * Created by lilla on 27/02/17.
 */

public class QuizResult {

    String question;
    List<String> answers;
    boolean ok;

    public QuizResult(String question, List<String> answers, boolean ok) {
        this.question = question;
        this.answers = answers;
        this.ok = ok;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
