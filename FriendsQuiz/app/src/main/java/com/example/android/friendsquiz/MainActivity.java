package com.example.android.friendsquiz;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private List<Quiz> quizs = new ArrayList<>();
    Map<String, List<String>> rightAnswers = new LinkedHashMap<>();
    int points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void incrementPoints() {
        points = ++points;
    }

    private void loadFirst() {
        quizs.clear();
        setContentView(R.layout.multi_answer_layout);
        Quiz quiz1 = initQuizOne();
        quizs.add(quiz1);
    }

    public void goToNext(View view) {

        switch (quizs.size()) {
            case 0:
                loadFirst();
                break;

            case 1:
                setContentView(R.layout.single_answer_layout);
                Quiz quiz2 = initQuizTwo();
                quizs.add(quiz2);
                break;

            case 2:
                setContentView(R.layout.text_answer_layout);
                Quiz quiz3 = initQuizThree();
                quizs.add(quiz3);
                break;

            case 3:
                setContentView(R.layout.single_answer_layout);
                Quiz quiz4 = initQuizFour();
                quizs.add(quiz4);
                break;

            case 4:
                setContentView(R.layout.single_answer_layout);
                Quiz quiz5 = initQuizFive();
                quizs.add(quiz5);
                break;

            case 5:
                setContentView(R.layout.multi_answer_layout);
                Quiz quiz6 = initQuizSix();
                quizs.add(quiz6);
                break;

            case 6:
                setContentView(R.layout.single_answer_layout);
                Quiz quiz7 = initQuizSeven();
                quizs.add(quiz7);
                break;

            case 7:
                setContentView(R.layout.multi_answer_layout);
                Quiz quiz8 = initQuizEight();
                quizs.add(quiz8);
                break;

            case 8:
                setContentView(R.layout.text_answer_layout);
                Quiz quiz9 = initQuizNine();
                quizs.add(quiz9);
                break;

            case 9:
                setContentView(R.layout.single_answer_layout);
                Quiz quiz10 = initQuizTen();
                quizs.add(quiz10);
                break;

            case 10:
                setContentView(R.layout.results_layout);
                collectCorrectAnswers();
                collectGivenAnswers();
                showResults();
                break;

            default:
                break;
        }
    }


    /*Collect the correct question and answers pairs into the rightAnswers LinkedHashMap*/
    public void collectCorrectAnswers() {
        for (Quiz quiz : quizs) {
            String question = quiz.getQuestion().getText().toString();
            List<String> correctAnswers = quiz.getCorrectAnswers();
            rightAnswers.put(question, correctAnswers);
        }
    }

    /*Collect the the given answers and put them into the givenAnswers LinkedHashMap */
    public void collectGivenAnswers() {
        for (Quiz quiz : quizs) {
            if (quiz instanceof MultiAnswerQuiz) {
                List<CheckBox> answerOptions = ((MultiAnswerQuiz) quiz).getAnswerOptions();
                List<String> answers = new ArrayList<>();
                for (CheckBox checkBox : answerOptions) {
                    if (checkBox.isChecked()) {
                        answers.add(checkBox.getText().toString());
                    }
                }
                quiz.setAnswer(answers);

            } else if (quiz instanceof SingleAnswerQuiz) {
                List<RadioButton> answerOptions = ((SingleAnswerQuiz) quiz).getAnswerOptions();
                List<String> answers = new ArrayList<>();
                for (RadioButton radioButton : answerOptions) {
                    if (radioButton.isChecked()) {
                        answers.add(radioButton.getText().toString());
                    }
                }
                quiz.setAnswer(answers);

            } else {
                List<String> answers = new ArrayList<>();
                answers.add(((TextAnswer) quiz).getAnswerField().getText().toString());
                quiz.setAnswer(answers);
            }
        }
    }


    public void showResults() {
        for (Quiz quiz: quizs) {
            QuizResult quizResult = new QuizResult(quiz.getQuestion().toString(), quiz.getAnswer(), false);
            if (quiz.getAnswer().toString().equals(quiz.getCorrectAnswers().toString())) {
                quizResult.setOk(true);
                incrementPoints();
            }
        }

        String pointsMessage = getString(R.string.points, points);
        displayPoints(pointsMessage);

        Toast toast = Toast.makeText(this, R.string.results_toast, Toast.LENGTH_SHORT);
        toast.show();
    }


    private Quiz initQuizOne() {

        //Create question
        TextView question = setTextViewValue(R.id.multi_a_question_text_view, getString(R.string.quiz1_question));

        //Create quiz
        Quiz quiz1 = new MultiAnswerQuiz(question,
                Arrays.asList(setCheckBoxValue(R.id.multi_a_answer1, getString(R.string.quiz1_answer_one)),
                        setCheckBoxValue(R.id.multi_a_answer2, getString(R.string.quiz1_answer_two)),
                        setCheckBoxValue(R.id.multi_a_answer3, getString(R.string.quiz1_answer_three)),
                        setCheckBoxValue(R.id.multi_a_answer4, getString(R.string.quiz1_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz1_correct_answer1),
                        getString(R.string.quiz1_correct_answer2),
                        getString(R.string.quiz1_correct_answer3)),
                R.layout.multi_answer_layout);

        return quiz1;
    }

    private Quiz initQuizTwo() {

        TextView question = setTextViewValue(R.id.single_a_question, getString(R.string.quiz2_question));

        Quiz quiz2 = new SingleAnswerQuiz(question,
                Arrays.asList(setRadioButtonValue(R.id.single_a_answer1, getString(R.string.quiz2_answer_one)),
                        setRadioButtonValue(R.id.single_a_answer2, getString(R.string.quiz2_answer_two)),
                        setRadioButtonValue(R.id.single_a_answer3, getString(R.string.quiz2_answer_three)),
                        setRadioButtonValue(R.id.single_a_answer4, getString(R.string.quiz2_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz2_correct_answer)),
                R.layout.single_answer_layout);

        return quiz2;
    }

    private Quiz initQuizThree() {
        TextView question = setTextViewValue(R.id.text_a_question, getString(R.string.quiz3_question));

        Quiz quiz3 = new TextAnswer(question,
                getTextField(R.id.text_a_answer),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz3_correct_answer)),
                R.layout.text_answer_layout);

        return quiz3;
    }

    private Quiz initQuizFour() {

        TextView question = setTextViewValue(R.id.single_a_question, getString(R.string.quiz4_question));

        Quiz quiz4 = new SingleAnswerQuiz(question,
                Arrays.asList(setRadioButtonValue(R.id.single_a_answer1, getString(R.string.quiz4_answer_one)),
                        setRadioButtonValue(R.id.single_a_answer2, getString(R.string.quiz4_answer_two)),
                        setRadioButtonValue(R.id.single_a_answer3, getString(R.string.quiz4_answer_three)),
                        setRadioButtonValue(R.id.single_a_answer4, getString(R.string.quiz4_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz4_correct_answer)),
                R.layout.single_answer_layout);

        return quiz4;
    }

    private Quiz initQuizFive() {

        TextView question = setTextViewValue(R.id.single_a_question, getString(R.string.quiz5_question));

        Quiz quiz5 = new SingleAnswerQuiz(question,
                Arrays.asList(setRadioButtonValue(R.id.single_a_answer1, getString(R.string.quiz5_answer_one)),
                        setRadioButtonValue(R.id.single_a_answer2, getString(R.string.quiz5_answer_two)),
                        setRadioButtonValue(R.id.single_a_answer3, getString(R.string.quiz5_answer_three)),
                        setRadioButtonValue(R.id.single_a_answer4, getString(R.string.quiz5_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz5_correct_answer)),
                R.layout.single_answer_layout);

        return quiz5;
    }

    private Quiz initQuizSix() {

        //Create question
        TextView question = setTextViewValue(R.id.multi_a_question_text_view, getString(R.string.quiz6_question));

        //Create quiz
        Quiz quiz6 = new MultiAnswerQuiz(question,
                Arrays.asList(setCheckBoxValue(R.id.multi_a_answer1, getString(R.string.quiz6_answer_one)),
                        setCheckBoxValue(R.id.multi_a_answer2, getString(R.string.quiz6_answer_two)),
                        setCheckBoxValue(R.id.multi_a_answer3, getString(R.string.quiz6_answer_three)),
                        setCheckBoxValue(R.id.multi_a_answer4, getString(R.string.quiz6_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz6_correct_answer1),
                        getString(R.string.quiz6_correct_answer2)),
                R.layout.multi_answer_layout);

        return quiz6;
    }

    private Quiz initQuizSeven() {

        TextView question = setTextViewValue(R.id.single_a_question, getString(R.string.quiz7_question));

        Quiz quiz7 = new SingleAnswerQuiz(question,
                Arrays.asList(setRadioButtonValue(R.id.single_a_answer1, getString(R.string.quiz7_answer_one)),
                        setRadioButtonValue(R.id.single_a_answer2, getString(R.string.quiz7_answer_two)),
                        setRadioButtonValue(R.id.single_a_answer3, getString(R.string.quiz7_answer_three)),
                        setRadioButtonValue(R.id.single_a_answer4, getString(R.string.quiz7_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz7_correct_answer)),
                R.layout.single_answer_layout);

        return quiz7;
    }

    private Quiz initQuizEight() {

        //Create question
        TextView question = setTextViewValue(R.id.multi_a_question_text_view, getString(R.string.quiz8_question));

        //Create quiz
        Quiz quiz8 = new MultiAnswerQuiz(question,
                Arrays.asList(setCheckBoxValue(R.id.multi_a_answer1, getString(R.string.quiz8_answer_one)),
                        setCheckBoxValue(R.id.multi_a_answer2, getString(R.string.quiz8_answer_two)),
                        setCheckBoxValue(R.id.multi_a_answer3, getString(R.string.quiz8_answer_three)),
                        setCheckBoxValue(R.id.multi_a_answer4, getString(R.string.quiz8_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz8_correct_answer1),
                        getString(R.string.quiz8_correct_answer2),
                        getString(R.string.quiz8_correct_answer3)),
                R.layout.multi_answer_layout);

        return quiz8;
    }

    private Quiz initQuizNine() {
        TextView question = setTextViewValue(R.id.text_a_question, getString(R.string.quiz9_question));

        Quiz quiz9 = new TextAnswer(question,
                getTextField(R.id.text_a_answer),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz9_correct_answer)),
                R.layout.text_answer_layout);

        return quiz9;
    }

    private Quiz initQuizTen() {

        TextView question = setTextViewValue(R.id.single_a_question, getString(R.string.quiz10_question));

        Quiz quiz10 = new SingleAnswerQuiz(question,
                Arrays.asList(setRadioButtonValue(R.id.single_a_answer1, getString(R.string.quiz10_answer_one)),
                        setRadioButtonValue(R.id.single_a_answer2, getString(R.string.quiz10_answer_two)),
                        setRadioButtonValue(R.id.single_a_answer3, getString(R.string.quiz10_answer_three)),
                        setRadioButtonValue(R.id.single_a_answer4, getString(R.string.quiz10_answer_four))),
                Arrays.asList(""),
                Arrays.asList(getString(R.string.quiz10_correct_answer)),
                R.layout.single_answer_layout);

        return quiz10;
    }

    private TextView setTextViewValue(@IdRes int id, String value) {
        TextView textView = (TextView) findViewById(id);
        textView.setText(value);
        return textView;
    }

    private CheckBox setCheckBoxValue(@IdRes int id, String value) {
        CheckBox checkBox = (CheckBox) findViewById(id);
        checkBox.setText(value);
        return checkBox;
    }

    private RadioButton setRadioButtonValue(@IdRes int id, String value) {
        RadioButton radioButton = (RadioButton) findViewById(id);
        radioButton.setText(value);
        return radioButton;
    }

    private EditText getTextField(@IdRes int id) {
        EditText editText = (EditText) findViewById(id);
        return editText;
    }


    private void displayPoints(String points) {
        TextView pointsTextView = (TextView) findViewById(R.id.points_text_view);
        pointsTextView.setText("" + points);
    }

}
