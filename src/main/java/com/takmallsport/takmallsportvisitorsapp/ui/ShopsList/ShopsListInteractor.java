package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.model.shops;

/**
 * Created by sahand on 4/12/18.
 */

public interface ShopsListInteractor {

    void OpenSelectedShop(shops shop);
    interface Listener {
        Context getContext();
    }
}
