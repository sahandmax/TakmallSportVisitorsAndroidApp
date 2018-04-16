package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.app.Activity;
import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;

/**
 * Created by sahand on 4/10/18.
 */

public interface ShopsListView {
    void setDataToRecycler(shopsAdapter adapter);
    Context getContext();
    Activity getActivity();
}
