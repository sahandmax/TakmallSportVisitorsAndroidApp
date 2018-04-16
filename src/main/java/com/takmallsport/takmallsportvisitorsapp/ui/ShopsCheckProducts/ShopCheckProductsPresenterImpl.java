package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.content.Intent;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;

/**
 * Created by sahand on 4/11/18.
 */

public class ShopCheckProductsPresenterImpl implements  ShopCheckProductsPresenter {
    ShopCheckProductsView shopCheckProductsView;

    public ShopCheckProductsPresenterImpl(ShopCheckProductsView shopCheckProductsView) {
        this.shopCheckProductsView = shopCheckProductsView;
    }


    @Override
    public void onCreate() {
        Intent intent = shopCheckProductsView.getActivity().getIntent();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_back:

                break;
            case R.id.button_not_have:

                break;
            case R.id.button_next:

                break;
        }
    }
}
