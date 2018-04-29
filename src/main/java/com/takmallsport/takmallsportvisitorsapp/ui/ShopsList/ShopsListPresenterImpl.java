package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.app.Activity;
import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsList.Interactors.ShopsListInteractor;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsList.Interactors.ShopsListInteractorImpl;

/**
 * Created by sahand on 4/10/18.
 */

public class ShopsListPresenterImpl implements  ShopsListPresenter , ShopsListInteractor.Listener {
    ShopsListView shopsListView;
    ShopsListInteractorImpl shopsListInteractor;
    public ShopsListPresenterImpl(ShopsListView shopsListView) {
        this.shopsListView = shopsListView;
        shopsListInteractor = new ShopsListInteractorImpl(this);
    }


    @Override
    public void onCreate() {
        shopsListInteractor.LoadShopsList();
    }

    @Override
    public void setDataToRecycler(shopsAdapter shopsAdapter) {
        shopsListView.setDataToRecycler(shopsAdapter);
    }

    @Override
    public Context getContext() {
        return shopsListView.getContext();
    }

    @Override
    public Activity getActivity() {
        return shopsListView.getActivity();
    }
}
