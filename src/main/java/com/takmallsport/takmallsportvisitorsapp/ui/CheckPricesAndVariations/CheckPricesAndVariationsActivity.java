package com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.adapter.variationAdapter;

public class CheckPricesAndVariationsActivity extends AppCompatActivity implements CheckPricesAndVariationsView, View.OnClickListener {
    TextInputLayout textInputLayout_price;
    RecyclerView recyclerView_variations;
    Button button_saveChanges;
    CheckPriceAndVariationsPresenter checkPriceAndVariationsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_prices_and_variations);
        checkPriceAndVariationsPresenter = new CheckPriceAndVariationsPresenterImpl(this);
        textInputLayout_price = findViewById(R.id.textInputLayout_price);
        recyclerView_variations = findViewById(R.id.recyclerView_variations);
        button_saveChanges = findViewById(R.id.button_saveChanges);
        button_saveChanges.setOnClickListener(this);
        checkPriceAndVariationsPresenter.onCreate();

    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void FinishActivity() {
        Toast.makeText(this,R.string.changes_saved_successfully,Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public String getPrice() {
        return textInputLayout_price.getEditText().getText().toString();
    }

    @Override
    public void LoadVariationsDataIntoRecycler(variationAdapter variationAdapter) {
        recyclerView_variations.setLayoutManager(new LinearLayoutManager(this));
        recyclerView_variations.setAdapter(variationAdapter);

    }

    @Override
    public void onClick(View view) {
        checkPriceAndVariationsPresenter.onClick(view);
    }
}
