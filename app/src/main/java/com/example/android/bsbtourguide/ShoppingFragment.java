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
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attractions> atractions = new ArrayList<>();
        atractions.add(new Attractions(getString(R.string.parkShopping), getString(R.string.parkShopping_location),R.drawable.park_shopping));
        atractions.add(new Attractions(getString(R.string.pier21Shopping), getString(R.string.pier21Shopping_location), R.drawable.pier21_shopping));
        atractions.add(new Attractions(getString(R.string.iguatemiShopping), getString(R.string.iguatemiShopping_location), R.drawable.iguatemi_shopping));
        atractions.add(new Attractions(getString(R.string.boulevardShopping), getString(R.string.boulevardShopping_location), R.drawable.boulevard_shopping));


        AttractionsAdapter adapter = new AttractionsAdapter(getActivity(), atractions);

        ListView listView = (ListView) rootView.findViewById(R.id.atractions_list);
        listView.setAdapter(adapter);

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
