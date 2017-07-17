package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by lilla on 15/07/17.
 */

public class CategoryFragmentPagerAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /*The number of attraction category pages to show*/
    private static final int NUM_PAGES = 4;

    public CategoryFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightsFragment();
        } else if (position == 1) {
            return new BeachesFragment();
        } else if (position == 2) {
            return new RestaurantsFragment();
        } else {
            return new EventsFragment();
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_label_sights);
        } else if (position == 1) {
            return mContext.getString(R.string.category_label_beaches);
        } else if (position == 2) {
            return mContext.getString(R.string.category_label_restaurants);
        } else {
            return mContext.getString(R.string.category_label_events);
        }
    }
}
