package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.relations;

public class ShopCheckProductsActivity extends AppCompatActivity implements ShopCheckProductsView, View.OnClickListener, View.OnLongClickListener {

    ImageView image_product;
    ShopCheckProductsPresenter presenter;
    TextView textView_ShopData;
    TextView textView_NumofProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_check_products);
        image_product = findViewById(R.id.image_product);
        textView_ShopData = findViewById(R.id.textView_ShopData);
        image_product.setOnClickListener(this);
        image_product.setOnLongClickListener(this);
        textView_NumofProducts = findViewById(R.id.textView_NumofProducts);
        findViewById(R.id.button_back).setOnClickListener(this);
        findViewById(R.id.button_not_have).setOnClickListener(this);
        findViewById(R.id.button_next).setOnClickListener(this);
        findViewById(R.id.button_change_price_and_variations).setOnClickListener(this);
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
        Glide.with(this)
                .applyDefaultRequestOptions(new RequestOptions().error(R.drawable.takmall).placeholder(R.drawable.takmall).fitCenter())
                .load(path).into(image_product);
    }

    @Override
    public void VisibleDescription() {
        textView_ShopData.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideDescription() {
        textView_ShopData.setVisibility(View.INVISIBLE);
    }

    @Override
    public void AlertFinishOfProducts() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setMessage(getString(R.string.you_finished_products_of_this_shop));
        builder.create().show();
    }

    @Override
    public void ToastYouAreAtFirstOfProducts() {
        Toast.makeText(this,R.string.you_are_at_first_of_products,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTextviewPageSize(String text) {
        textView_NumofProducts.setText(text);
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
