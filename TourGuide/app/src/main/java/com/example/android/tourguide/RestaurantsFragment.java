package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> restaurants = new ArrayList<Attraction>();

        restaurants.add(new Attraction(getText(R.string.restaurant_1_name).toString(),
                getText(R.string.restaurant_1_description_2).toString(),
                getText(R.string.restaurant_1_address).toString(),
                getText(R.string.restaurant_1_geolocation).toString(),
                R.drawable.la_canasta
                ));
        restaurants.add(new Attraction(getText(R.string.restaurant_2_name).toString(),
                getText(R.string.restaurant_2_description_2).toString(),
                getText(R.string.restaurant_2_address).toString(),
                getText(R.string.restaurant_2_geolocation).toString(),
                R.drawable.jimera
        ));
        restaurants.add(new Attraction(getText(R.string.restaurant_3_name).toString(),
                getText(R.string.restaurant_3_description_2).toString(),
                getText(R.string.restaurant_3_address).toString(),
                getText(R.string.restaurant_3_geolocation).toString(),
                R.drawable.mercado_gourmet
        ));
        restaurants.add(new Attraction(getText(R.string.restaurant_4_name).toString(),
                getText(R.string.restaurant_4_description_2).toString(),
                getText(R.string.restaurant_4_address).toString(),
                getText(R.string.restaurant_4_geolocation).toString(),
                R.drawable.giolatto
        ));
        restaurants.add(new Attraction(getText(R.string.restaurant_5_name).toString(),
                getText(R.string.restaurant_5_description_2).toString(),
                getText(R.string.restaurant_5_address).toString(),
                getText(R.string.restaurant_5_geolocation).toString(),
                R.drawable.da_bruno
        ));
        restaurants.add(new Attraction(getText(R.string.restaurant_6_name).toString(),
                getText(R.string.restaurant_6_description_2).toString(),
                getText(R.string.restaurant_6_address).toString(),
                getText(R.string.restaurant_6_geolocation).toString(),
                R.drawable.gourmet_burger_room
        ));
        restaurants.add(new Attraction(getText(R.string.restaurant_7_name).toString(),
                getText(R.string.restaurant_7_description_2).toString(),
                getText(R.string.restaurant_7_address).toString(),
                getText(R.string.restaurant_7_geolocation).toString(),
                R.drawable.la_marina
        ));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), restaurants);

        ListView listView = (ListView) rootView.findViewById(R.id.attraction_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction attraction = restaurants.get(position);
                openMap(Uri.parse(attraction.getGeoLocation()));
            }
        });

        return rootView;
    }

    public void openMap(Uri geoLocation){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
