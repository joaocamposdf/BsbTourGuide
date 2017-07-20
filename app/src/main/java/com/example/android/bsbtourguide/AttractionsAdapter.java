package com.example.android.bsbtourguide;

import android.app.Activity;
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
 * Created by Note on 17/07/2017.
 */

public class AttractionsAdapter extends ArrayAdapter<Attractions> {
    public AttractionsAdapter(@NonNull Activity context, @NonNull ArrayList<Attractions> attractions) {
        super(context,0 , attractions);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
//Display or not each part of the list_item.xml
        Attractions currentattraction = getItem(position);
        ImageView attractionImage = (ImageView) listItemView.findViewById(R.id.attractionImage);
        attractionImage.setImageResource(currentattraction.getImage());

        TextView attractionName = (TextView) listItemView.findViewById(R.id.attractionName);
        attractionName.setText(currentattraction.getName());

//This TextView was not shown, because it was the way I found to match each attraction location to the item clicked on the list.
        TextView attractionLocation = (TextView) listItemView.findViewById(R.id.attractionLocation);
        attractionLocation.setText(currentattraction.getLocation());
        attractionLocation.setVisibility(View.GONE);


        return listItemView;
    }
}
