package com.example.android.friendsquiz;

import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class MultiAnswerQuiz extends Quiz {

    private List<CheckBox> answerOptions;

    public MultiAnswerQuiz(TextView question, List<CheckBox> answerOptions, List<String> answer, List<String> correctAnswers,  int templateId) {
        super(question, answer, correctAnswers, templateId);
        this.answerOptions = answerOptions;
    }

    public List<CheckBox> getAnswerOptions() {
        return answerOptions;
    }
}
