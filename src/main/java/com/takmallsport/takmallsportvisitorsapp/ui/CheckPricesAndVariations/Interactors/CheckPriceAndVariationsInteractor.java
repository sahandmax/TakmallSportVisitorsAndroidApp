package com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations.Interactors;

import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.adapter.variationAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.relations;

/**
 * Created by sahand on 4/23/18.
 */

public interface CheckPriceAndVariationsInteractor {
    void LoadVariations();
    void SaveChanges();
    interface Listener{
        Activity getActivity();
        void LoadVariationsDataIntoRecycler(variationAdapter variationAdapter);
        String getPrice();
        void FinishActivity();
    }
}
