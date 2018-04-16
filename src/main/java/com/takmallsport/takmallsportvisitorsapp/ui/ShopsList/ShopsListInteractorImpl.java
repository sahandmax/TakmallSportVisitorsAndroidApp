package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.content.Context;
import android.content.Intent;

import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts.ShopCheckProductsActivity;

/**
 * Created by sahand on 4/12/18.
 */

public class ShopsListInteractorImpl implements  ShopsListInteractor {

    ShopsListInteractor.Listener listener;
    Context context;

    public ShopsListInteractorImpl(Listener listener) {
        this.listener = listener;
    }


    @Override
    public void OpenSelectedShop(shops shop) {
        Intent i = new Intent(context , ShopCheckProductsActivity.class);
        i.putExtra("shop",shop);
        context.startActivity(i);
    }
}
