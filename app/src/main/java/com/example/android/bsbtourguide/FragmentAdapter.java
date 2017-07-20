package com.example.android.bsbtourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Note on 17/07/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private Context context;

    public FragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FoodFragment();
        } else if (position == 1) {
            return new ParksFragment();
        } else if (position == 2) {
            return new ShoppingFragment();
        } else
            return new PublicPlacesFragment();

    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.food);
        } else if (position == 1) {
            return context.getString(R.string.parks);
        } else if (position == 2) {
            return context.getString(R.string.shopping);
        } else
            return context.getString(R.string.publicPlaces);

    }
}
