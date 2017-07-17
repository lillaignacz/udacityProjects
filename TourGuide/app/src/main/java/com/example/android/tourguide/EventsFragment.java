package com.example.android.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> events = new ArrayList<Attraction>();

        events.add(new Attraction(getText(R.string.event_1_name).toString(),
                getText(R.string.event_1_description_2).toString(),
                R.drawable.semana_santa
        ));

        events.add(new Attraction(getText(R.string.event_2_name).toString(),
                getText(R.string.event_2_description_2).toString(),
                R.drawable.feria
        ));

        events.add(new Attraction(getText(R.string.event_3_name).toString(),
                getText(R.string.event_3_description_2).toString(),
                R.drawable.san_juan
        ));

        events.add(new Attraction(getText(R.string.event_4_name).toString(),
                getText(R.string.event_4_description_2).toString(),
                R.drawable.three_kings
        ));

        events.add(new Attraction(getText(R.string.event_5_name).toString(),
                getText(R.string.event_5_description_2).toString(),
                R.drawable.starlite
        ));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), events);

        ListView listView = (ListView) rootView.findViewById(R.id.attraction_list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
