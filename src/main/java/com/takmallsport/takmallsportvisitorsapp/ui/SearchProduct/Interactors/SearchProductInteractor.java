package com.takmallsport.takmallsportvisitorsapp.ui.SearchProduct.Interactors;

import android.app.Activity;

/**
 * Created by sahand on 4/23/18.
 */

public interface SearchProductInteractor {
    void ViewProduct(String sku);
    interface Listener {
        Activity getActivity();
        void ProductNotFound();
    }
}
