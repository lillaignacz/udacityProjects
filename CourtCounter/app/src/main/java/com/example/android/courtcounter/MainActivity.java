package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.android.courtcounter.R.string.teamA;
import static com.example.android.courtcounter.R.string.teamB;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int redTeamA = 0;
    int redTeamB = 0;
    int yellowTeamA = 0;
    int yellowTeamB = 0;

    /*increment score for team A*/

    public void addScoreForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayScoreForTeamA(scoreTeamA);
    }

    public void redCardForTeamA(View view) {
        redTeamA = redTeamA + 1;
        displayRedForTeamA(redTeamA);
    }

    public void yellowCardForTeamA(View view) {
        yellowTeamA = yellowTeamA + 1;
        displayYellowForTeamA(yellowTeamA);
    }

    /*Increment score for team B*/
    public void addScoreForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayScoreForTeamB(scoreTeamB);
    }

    public void redCardForTeamB(View view) {
        redTeamB = redTeamB + 1;
        displayRedForTeamB(redTeamB);
    }

    public void yellowCardForTeamB(View view) {
        yellowTeamB = yellowTeamB + 1;
        displayYellowForTeamB(yellowTeamB);
    }


    public void resetPoints(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        redTeamA = 0;
        redTeamB = 0;
        yellowTeamA = 0;
        yellowTeamB = 0;

        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        displayRedForTeamA(redTeamA);
        displayRedForTeamB(redTeamB);
        displayYellowForTeamA(yellowTeamA);
        displayYellowForTeamB(yellowTeamB);
        displayWinner(" ");
    }


    public void endGame(View view) {
        if (scoreTeamA > scoreTeamB) {
            displayWinner(getString(teamA) +" is the winner");;
        }
        else if(scoreTeamB > scoreTeamA){
            displayWinner(getString(teamB) +" is the winner");;
        }
        else {
            displayWinner("Draw");
        }

    }


    /*Displays the given score for Team A*/
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_red);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_yellow);
        scoreView.setText(String.valueOf(score));
    }

    /*Displays the given score for Team B*/
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayRedForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_red);
        scoreView.setText(String.valueOf(score));
    }

    public void displayYellowForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_yellow);
        scoreView.setText(String.valueOf(score));
    }


    public void displayWinner(String message) {
        TextView teamNameView = (TextView) findViewById(R.id.winner);
        teamNameView.setText(message);
    }

}
