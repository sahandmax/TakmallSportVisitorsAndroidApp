package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts.ShopCheckProductsActivity;
import com.takmallsport.takmallsportvisitorsapp.util.StoragePermisssions;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;

import java.util.ArrayList;

/**
 * Created by sahand on 4/12/18.
 */

public class ShopsListInteractorImpl implements  ShopsListInteractor, com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter.OnClickListener {

    ShopsListInteractor.Listener listener;
    Context context;
    ArrayList<shops> shopsListArray;
    shopsAdapter shopsAdapter;

    public ShopsListInteractorImpl(Listener listener) {
        this.listener = listener;
        context = listener.getContext();
    }


    @Override
    public void LoadShopsList() {
        if (new StoragePermisssions().checkAndRequestPermissions(listener.getActivity())) {
            MainDbHelper db = new MainDbHelper(listener.getContext());
            shopsListArray = db.getShopList();
            shopsAdapter = new shopsAdapter(shopsListArray, listener.getContext());
            shopsAdapter.setOnClickListener(this);
            listener.setDataToRecycler(shopsAdapter);

        } else {
            try {
                Thread.sleep(100);
                LoadShopsList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void OpenSelectedShop(shops shop) {
        Intent i = new Intent(context , ShopCheckProductsActivity.class);
        i.putExtra("shop",shop);
        context.startActivity(i);
    }

    @Override
    public void onClick(View view, int ViewType, int AdapterPosition) {
        OpenSelectedShop(shopsListArray.get(AdapterPosition));
    }
}
