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
public class PublicPlacesFragment extends Fragment {


    public PublicPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attractions_list, container, false);

        final ArrayList<Attractions> atractions = new ArrayList<>();
        atractions.add(new Attractions(getString(R.string.ministries_avenue), getString(R.string.ministriesAvenue_location),R.drawable.ministries_avenue));
        atractions.add(new Attractions(getString(R.string.tv_tower), getString(R.string.tvTower_location), R.drawable.tv_tower));
        atractions.add(new Attractions(getString(R.string.cathedral), getString(R.string.cathedral_location), R.drawable.cathedral));
        atractions.add(new Attractions(getString(R.string.memorialJK), getString(R.string.memorialJK_location), R.drawable.memorial_jk));

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

        return rootView;    }

}
