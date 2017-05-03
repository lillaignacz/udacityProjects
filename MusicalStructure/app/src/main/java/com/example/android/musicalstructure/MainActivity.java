package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView album = (TextView) findViewById(R.id.home_to_album_details);
        album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent albumIntent = new Intent(MainActivity.this, AlbumDetailsActivity.class);
                startActivity(albumIntent);
            }
        });

        TextView favourites = (TextView) findViewById(R.id.home_to_favourites);
        favourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent favouritesIntent = new Intent(MainActivity.this, FavouritesActivity.class);
                startActivity(favouritesIntent);
            }
        });

    }
}
