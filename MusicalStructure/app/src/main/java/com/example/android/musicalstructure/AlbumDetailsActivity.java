package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AlbumDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_details);

        TextView play = (TextView) findViewById(R.id.album_details_to_now_playing);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(AlbumDetailsActivity.this, NowPlayingActivity.class);
                startActivity(playIntent);
            }
        });

        TextView save = (TextView) findViewById(R.id.album_details_to_favourites);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saveIntent = new Intent(AlbumDetailsActivity.this, FavouritesActivity.class);
                startActivity(saveIntent);
            }
        });

        TextView home = (TextView) findViewById(R.id.album_details_to_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(AlbumDetailsActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });

    }
}
