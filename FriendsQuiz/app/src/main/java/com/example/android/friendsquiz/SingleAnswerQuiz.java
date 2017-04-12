package com.example.android.friendsquiz;

import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lilla on 12/02/17.
 */

public class SingleAnswerQuiz extends Quiz {

    private List<RadioButton> answerOptions;

    public SingleAnswerQuiz(TextView question, List<RadioButton> answerOptions, List<String> answer, List<String> correctAnswers, int templateId) {
        super(question, answer, correctAnswers, templateId);
        this.answerOptions = answerOptions;
    }

    public List<RadioButton> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<RadioButton> answerOptions) {
        this.answerOptions = answerOptions;
    }
}
