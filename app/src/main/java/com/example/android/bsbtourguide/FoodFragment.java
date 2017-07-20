package com.example.android.bsbtourguide;


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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);
//List of attractions that will be displayed on each tab
        final ArrayList<Attractions> atractions = new ArrayList<>();
        atractions.add(new Attractions(getString(R.string.madero), getString(R.string.madero_location),R.drawable.madero));
        atractions.add(new Attractions(getString(R.string.outback), getString(R.string.outback_location), R.drawable.outback));
        atractions.add(new Attractions(getString(R.string.landi),getString(R.string.landi_location),R.drawable.landi));
        atractions.add(new Attractions(getString(R.string.pastel_mix), getString(R.string.pastelMix_location), R.drawable.pastel_mix));

//Adapter that handles the interaction of Attractions list to be shown on the listView
        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), atractions);

        ListView listView = (ListView) rootView.findViewById(R.id.atractions_list);
        listView.setAdapter(adapter);

//When the user clicks on each list item, he/she will be redirected to the attraction location on google maps.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Attractions attraction = atractions.get(position);
                Uri gmmIntentUri = Uri.parse(attraction.getLocation());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

        return rootView;
    }
    }
