package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts.Interactors;

import android.app.Activity;
import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

/**
 * Created by sahand on 4/22/18.
 */

public interface ShopCheckProductsIntentsInteractor {
    void ChangePriceAndVariations(relations relation);
    interface Listener {
        Activity getActivity();
    }
}
