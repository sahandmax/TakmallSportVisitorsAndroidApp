package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;
import com.takmallsport.takmallsportvisitorsapp.util.StoragePermisssions;

import java.util.ArrayList;

/**
 * Created by sahand on 4/10/18.
 */

public class ShopsListPresenterImpl implements  ShopsListPresenter{
    ShopsListView shopsListView;
    ArrayList<shops> shopsListArray;
    shopsAdapter shopsAdapter;

    public ShopsListPresenterImpl(ShopsListView shopsListView) {
        this.shopsListView = shopsListView;
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


}
