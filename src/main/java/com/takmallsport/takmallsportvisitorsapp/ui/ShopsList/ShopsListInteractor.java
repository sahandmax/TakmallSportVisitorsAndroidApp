package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.app.Activity;
import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.shops;

/**
 * Created by sahand on 4/12/18.
 */

public interface ShopsListInteractor {

    void LoadShopsList();
    void OpenSelectedShop(shops shop);
    interface Listener {
        Context getContext();
        Activity getActivity();
        void setDataToRecycler(shopsAdapter adapter);
    }
}
