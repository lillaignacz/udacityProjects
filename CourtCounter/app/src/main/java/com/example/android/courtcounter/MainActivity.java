package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Team team1 = new Team(getText(R.string.teamA).toString(), 0, 0, 0);
        final Team team2 = new Team(getText(R.string.teamB).toString(), 0, 0, 0);

        Button scoreTeam1 = (Button) findViewById(R.id.score_button_team1);
        scoreTeam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team1.updateScore((TextView) findViewById(R.id.score_display_team1));
            }
        });


        Button scoreTeam2 = (Button) findViewById(R.id.score_button_team2);
        scoreTeam2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team2.updateScore((TextView) findViewById(R.id.score_display_team2));
            }
        });

        Button redTeam1 = (Button) findViewById(R.id.red_button_team1);
        redTeam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team1.updateRedCard((TextView) findViewById(R.id.red_display_team1));
            }
        });


        Button redTeam2 = (Button) findViewById(R.id.red_button_team2);
        redTeam2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team2.updateRedCard((TextView) findViewById(R.id.red_display_team2));
            }
        });

        Button yellowTeam1 = (Button) findViewById(R.id.yellow_button_team1);
        yellowTeam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team1.updateYellowCard((TextView) findViewById(R.id.yellow_display_team1));
            }
        });


        Button yellowTeam2 = (Button) findViewById(R.id.yellow_button_team2);
        yellowTeam2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team2.updateYellowCard((TextView) findViewById(R.id.yellow_display_team2));
            }
        });


        Button finishButton = (Button) findViewById(R.id.end_game_button);
        final LinearLayout gameControlLayout = (LinearLayout) findViewById(R.id.game_control_layout);
        final TextView resultView = new TextView(this);
        resultView.setGravity(Gravity.CENTER);
        resultView.setTextColor(getResources().getColor(R.color.colorPrimary));
        resultView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);

        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (team1.getScore() > team2.getScore()) {
                    resultView.setText(R.string.teamAWin);
                    gameControlLayout.addView(resultView);
                } else if (team2.getScore() > team1.getScore()) {
                    resultView.setText(R.string.teamBWin);
                    gameControlLayout.addView(resultView);
                } else {
                    resultView.setText(R.string.draw);

                    gameControlLayout.addView(resultView);
                }
            }
        });

        Button resetButton = (Button) findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                team1.resetScore((TextView) findViewById(R.id.score_display_team1));
                team2.resetScore((TextView) findViewById(R.id.score_display_team2));
                team1.resetRedCard((TextView) findViewById(R.id.red_display_team1));
                team2.resetRedCard((TextView) findViewById(R.id.red_display_team2));
                team1.resetYellowCard((TextView) findViewById(R.id.yellow_display_team1));
                team2.resetYellowCard((TextView) findViewById(R.id.yellow_display_team2));
                gameControlLayout.removeView(resultView);
                Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
