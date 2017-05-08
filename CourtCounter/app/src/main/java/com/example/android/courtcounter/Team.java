package com.example.android.courtcounter;

import android.widget.TextView;

public class Team {

    private String name;
    private int score;
    private int redCard;
    private int yellowCard;

    public Team(String name, int score, int redCard, int yellowCard) {
        this.name = name;
        this.score = score;
        this.redCard = redCard;
        this.yellowCard = yellowCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public void updateScore(TextView scoreView){
        score++;
        scoreView.setText(String.valueOf(score));
    }

    public void updateRedCard(TextView redCardView){
        redCard++;
        redCardView.setText(String.valueOf(redCard));
    }

    public void updateYellowCard(TextView yellowCardView){
        yellowCard++;
        yellowCardView.setText(String.valueOf(yellowCard));
    }

    public void resetScore(TextView scoreView){
        setScore(0);
        scoreView.setText(String.valueOf(score));
    }

    public void resetRedCard(TextView redCardView){
        setRedCard(0);
        redCardView.setText(String.valueOf(redCard));
    }

    public void resetYellowCard(TextView yellowCardView){
        setYellowCard(0);
        yellowCardView.setText(String.valueOf(yellowCard));
    }

}
