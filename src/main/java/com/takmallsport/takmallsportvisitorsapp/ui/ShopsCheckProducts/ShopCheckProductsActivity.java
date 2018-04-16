package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.takmallsport.takmallsportvisitorsapp.R;

public class ShopCheckProductsActivity extends AppCompatActivity implements ShopCheckProductsView {

    ShopCheckProductsPresenter shopCheckProductsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_check_products);
        shopCheckProductsPresenter = new ShopCheckProductsPresenterImplement(this);
        shopCheckProductsPresenter.onCreate();
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
