package com.example.android.friendsquiz;

import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lilla on 12/02/17.
 */

public class TextAnswer extends Quiz {

    EditText answerField;

    public TextAnswer(TextView question, EditText answerField, List<String> answer, List<String> correctAnswers, int templateId) {
        super(question, answer, correctAnswers, templateId);
        this.answerField = answerField;
    }

    public EditText getAnswerField() {
        return answerField;
    }
}
