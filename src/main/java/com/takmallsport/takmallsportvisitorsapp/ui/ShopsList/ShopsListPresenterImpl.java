package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;
import com.takmallsport.takmallsportvisitorsapp.util.StoragePermisssions;

import java.util.ArrayList;

/**
 * Created by sahand on 4/10/18.
 */

public class ShopsListPresenterImpl implements  ShopsListPresenter , ShopsListInteractor.Listener{
    ShopsListView shopsListView;
    ArrayList<shops> shopsListArray;
    shopsAdapter shopsAdapter;
    ShopsListInteractorImpl shopsListInteractor;
    public ShopsListPresenterImpl(ShopsListView shopsListView) {
        this.shopsListView = shopsListView;
        shopsListInteractor = new ShopsListInteractorImpl(this);
    }


    @Override
    public void onCreate() {
        if (new StoragePermisssions().checkAndRequestPermissions(shopsListView.getActivity())) {
            MainDbHelper db = new MainDbHelper(shopsListView.getContext());
            shopsListArray = db.getShopList();
            shopsAdapter = new shopsAdapter(shopsListArray, shopsListView.getContext());
            shopsListView.setDataToRecycler(shopsAdapter);

        } else {
            try {
                Thread.sleep(100);
                onCreate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void setDataToRecycler(shopsAdapter shopsAdapter) {
        shopsListView.setDataToRecycler(shopsAdapter);
    }

    @Override
    public Context getContext() {
        return shopsListView.getContext();
    }
}
