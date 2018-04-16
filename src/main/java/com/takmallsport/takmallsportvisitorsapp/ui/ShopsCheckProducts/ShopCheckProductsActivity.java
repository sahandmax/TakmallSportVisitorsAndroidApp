package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.takmallsport.takmallsportvisitorsapp.R;

public class ShopCheckProductsActivity extends AppCompatActivity implements ShopCheckProductsView, View.OnClickListener {

    ImageView image_product;
    ShopCheckProductsPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_check_products);
        image_product = findViewById(R.id.image_product);
        findViewById(R.id.button_back).setOnClickListener(this);
        findViewById(R.id.button_not_have).setOnClickListener(this);
        findViewById(R.id.button_next).setOnClickListener(this);

        presenter = new ShopCheckProductsPresenterImpl(this);
        presenter.onCreate();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void onClick(View view) {
        presenter.onClick(view);
    }
}
