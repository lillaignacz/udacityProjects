package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lilla on 15/07/17.
 */

public class AttractionAdapter extends ArrayAdapter<Attraction> {

    public AttractionAdapter(@NonNull Context context, ArrayList<Attraction> attractions) {
        super(context, 0, attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Attraction currentAttraction = getItem(position);

        TextView description1 = (TextView) listItemView.findViewById(R.id.description_1);
        description1.setText(currentAttraction.getDescription1());

        TextView description2 = (TextView) listItemView.findViewById(R.id.description_2);
        description2.setText(currentAttraction.getDescription2());

        TextView description3 = (TextView) listItemView.findViewById(R.id.description_3);
        if (currentAttraction.getDescription3() != null) {
            description3.setText(currentAttraction.getDescription3());
            description3.setVisibility(View.VISIBLE);
        } else {
            description3.setVisibility(View.GONE);
        }

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.img);
        imageView.setImageResource(currentAttraction.getImgId());

        return listItemView;
    }

}