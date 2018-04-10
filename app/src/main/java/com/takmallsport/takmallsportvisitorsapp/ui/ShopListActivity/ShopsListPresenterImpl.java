package com.takmallsport.takmallsportvisitorsapp.ui.ShopListActivity;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;

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
        MainDbHelper db = new MainDbHelper(shopsListView.getContext());
        shopsListArray = db.getShopList();
        shopsAdapter = new shopsAdapter(shopsListArray,shopsListView.getContext());
        shopsListView.setDataToRecycler(shopsAdapter);
    }
}
