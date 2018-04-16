package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.content.Intent;

/**
 * Created by sahand on 4/11/18.
 */

public class ShopCheckProductsPresenterImplement implements  ShopCheckProductsPresenter {
    ShopCheckProductsView shopCheckProductsView;

    public ShopCheckProductsPresenterImplement(ShopCheckProductsView shopCheckProductsView) {
        this.shopCheckProductsView = shopCheckProductsView;
    }


    @Override
    public void onCreate() {
        Intent intent = shopCheckProductsView.getActivity().getIntent();

    }
}
