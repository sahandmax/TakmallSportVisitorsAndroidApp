package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;

/**
 * Created by sahand on 4/10/18.
 */

public interface ShopsListPresenter {
    void onCreate();
    void setDataToRecycler(shopsAdapter shopsAdapter);
}
