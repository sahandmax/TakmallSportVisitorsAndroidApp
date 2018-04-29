package com.takmallsport.takmallsportvisitorsapp.ui.SearchProduct;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.takmallsport.takmallsportvisitorsapp.R;

public class SearchProductActivity extends AppCompatActivity implements SearchProductView, View.OnClickListener {

    SearchProductPresenter searchProductPresenter;
    TextInputLayout textInputLayout_sku;
    Button button_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        searchProductPresenter = new SearchProductPresenterImpl(this);
        textInputLayout_sku = findViewById(R.id.textInputLayout_sku);
        button_search = findViewById(R.id.button_search);
        button_search.setOnClickListener(this);
        searchProductPresenter.onCreate();
    }

    @Override
    public void onClick(View view) {
        searchProductPresenter.onClick(view);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void ProductNotFound() {
        Toast.makeText(this,R.string.product_not_found,Toast.LENGTH_SHORT).show();
    }

}
