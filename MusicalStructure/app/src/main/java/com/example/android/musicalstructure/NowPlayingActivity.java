package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView home = (TextView) findViewById(R.id.now_playing_to_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(NowPlayingActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

        TextView favourites = (TextView) findViewById(R.id.now_playing_to_favourites);
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favourites = new Intent(NowPlayingActivity.this, FavouritesActivity.class);
                startActivity(favourites);
            }
        });

    }

}
