package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class FavouritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        TextView play = (TextView) findViewById(R.id.favourites_to_now_playing);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(FavouritesActivity.this, NowPlayingActivity.class);
                startActivity(playIntent);
            }
        });

        TextView home = (TextView) findViewById(R.id.favourites_to_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(FavouritesActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

    }
}
