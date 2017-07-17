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
public class BeachesFragment extends Fragment {

    public BeachesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> beaches = new ArrayList<Attraction>();

        beaches.add(new Attraction(getText(R.string.beach_1_name).toString(),
                getText(R.string.beach_1_description_2).toString(),
                getText(R.string.beach_1_address).toString(),
                getText(R.string.beach_1_geolocation).toString(),
                R.drawable.playa_venus
        ));

        beaches.add(new Attraction(getText(R.string.beach_2_name).toString(),
                getText(R.string.beach_2_description_2).toString(),
                getText(R.string.beach_2_address).toString(),
                getText(R.string.beach_2_geolocation).toString(),
                R.drawable.playa_faro
        ));

        beaches.add(new Attraction(getText(R.string.beach_3_name).toString(),
                getText(R.string.beach_3_description_2).toString(),
                getText(R.string.beach_3_address).toString(),
                getText(R.string.beach_3_geolocation).toString(),
                R.drawable.playa_nagueles
        ));

        beaches.add(new Attraction(getText(R.string.beach_4_name).toString(),
                getText(R.string.beach_4_description_2).toString(),
                getText(R.string.beach_4_address).toString(),
                getText(R.string.beach_4_geolocation).toString(),
                R.drawable.playa_cabopino
        ));

        beaches.add(new Attraction(getText(R.string.beach_5_name).toString(),
                getText(R.string.beach_5_description_2).toString(),
                getText(R.string.beach_5_address).toString(),
                getText(R.string.beach_5_geolocation).toString(),
                R.drawable.nikki_beach
        ));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), beaches);

        ListView listView = (ListView) rootView.findViewById(R.id.attraction_list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attraction attraction = beaches.get(position);
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
