package com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.takmallsport.takmallsportvisitorsapp.R;

public class FoundProductActivity extends AppCompatActivity implements FoundProductView, View.OnClickListener, View.OnLongClickListener {
    ImageView image_product;
    TextView textView_ShopData;
    FoundProductPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_found_product);
        presenter = new FoundProductPresenterImpl(this);
        image_product = findViewById(R.id.image_product);
        textView_ShopData = findViewById(R.id.textView_ShopData);
        image_product.setOnClickListener(this);
        image_product.setOnLongClickListener(this);
        presenter.onCreate();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void LoadImageOnImageView(String path) {
        Glide.with(this)
                .applyDefaultRequestOptions(new RequestOptions().error(R.drawable.takmall).placeholder(R.drawable.takmall).fitCenter())
                .load(path).into(image_product);
    }

    @Override
    public void LoadDetail(String text) {
        textView_ShopData.setText(text);
    }

    @Override
    public void onClick(View view) {
        textView_ShopData.setVisibility(View.INVISIBLE);
        presenter.onClick(view);
    }

    @Override
    public boolean onLongClick(View view) {
        textView_ShopData.setVisibility(View.VISIBLE);
        return false;
    }
}
