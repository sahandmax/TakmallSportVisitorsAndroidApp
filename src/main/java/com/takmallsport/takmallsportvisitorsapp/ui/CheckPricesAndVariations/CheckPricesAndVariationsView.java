package com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations;

import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.adapter.variationAdapter;

/**
 * Created by sahand on 4/23/18.
 */

public interface CheckPricesAndVariationsView {
    Activity getActivity();
    void FinishActivity();
    String getPrice();

    void LoadVariationsDataIntoRecycler(variationAdapter variationAdapter);

}
