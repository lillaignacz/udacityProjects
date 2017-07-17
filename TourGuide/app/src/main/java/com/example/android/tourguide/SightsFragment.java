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
public class SightsFragment extends Fragment {

    public SightsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> sights = new ArrayList<Attraction>();

        sights.add(new Attraction(getText(R.string.sight_1_name).toString(),
                getText(R.string.sight_1_description_2).toString(),
                getText(R.string.sight_1_address).toString(),
                getText(R.string.sight_1_geolocation).toString(),
                R.drawable.old_town
        ));

        sights.add(new Attraction(getText(R.string.sight_2_name).toString(),
                getText(R.string.sight_2_description_2).toString(),
                getText(R.string.sight_2_address).toString(),
                getText(R.string.sight_2_geolocation).toString(),
                R.drawable.avenida_del_mar
        ));

        sights.add(new Attraction(getText(R.string.sight_3_name).toString(),
                getText(R.string.sight_3_description_2).toString(),
                getText(R.string.sight_3_address).toString(),
                getText(R.string.sight_3_geolocation).toString(),
                R.drawable.park_alameda
        ));

        sights.add(new Attraction(getText(R.string.sight_4_name).toString(),
                getText(R.string.sight_4_description_2).toString(),
                getText(R.string.sight_4_address).toString(),
                getText(R.string.sight_4_geolocation).toString(),
                R.drawable.paseo_maritimo
        ));

        sights.add(new Attraction(getText(R.string.sight_5_name).toString(),
                getText(R.string.sight_5_description_2).toString(),
                getText(R.string.sight_5_address).toString(),
                getText(R.string.sight_5_geolocation).toString(),
                R.drawable.puerto_deportivo
        ));

        sights.add(new Attraction(getText(R.string.sight_6_name).toString(),
                getText(R.string.sight_6_description_2).toString(),
                getText(R.string.sight_6_address).toString(),
                getText(R.string.sight_6_geolocation).toString(),
                R.drawable.puerto_banus
        ));

        sights.add(new Attraction(getText(R.string.sight_7_name).toString(),
                getText(R.string.sight_7_description_2).toString(),
                getText(R.string.sight_7_address).toString(),
                getText(R.string.sight_7_geolocation).toString(),
                R.drawable.aventura_amazonia
        ));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), sights);

        ListView listView = (ListView) rootView.findViewById(R.id.attraction_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction attraction = sights.get(position);
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
