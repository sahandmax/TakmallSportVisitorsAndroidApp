package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.relations;

public class ShopCheckProductsActivity extends AppCompatActivity implements ShopCheckProductsView, View.OnClickListener, View.OnLongClickListener {

    ImageView image_product;
    ShopCheckProductsPresenter presenter;
    TextView textView_ShopData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_check_products);
        image_product = findViewById(R.id.image_product);
        textView_ShopData = findViewById(R.id.textView_ShopData);
        image_product.setOnLongClickListener(this);
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
    public void LoadDetail(String detail) {
        textView_ShopData.setText(detail);
    }

    @Override
    public void LoadImageOnImageView(String path) {
        Glide.with(this).applyDefaultRequestOptions(new RequestOptions().error(R.drawable.takmall).placeholder(R.drawable.takmall)).load(path).into(image_product);
    }


    @Override
    public void onClick(View view) {
        presenter.onClick(view);
    }

    @Override
    public boolean onLongClick(View view) {
        presenter.onLongClick(view);
        return false;
    }
}
