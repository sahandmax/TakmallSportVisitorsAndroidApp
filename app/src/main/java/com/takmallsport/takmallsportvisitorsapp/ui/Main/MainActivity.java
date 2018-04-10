package com.takmallsport.takmallsportvisitorsapp.ui.Main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.takmallsport.takmallsportvisitorsapp.R;

public class MainActivity extends AppCompatActivity implements  MainView, View.OnClickListener {
    Button button_check_products;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this);
        button_check_products = findViewById(R.id.button_check_products);
        button_check_products.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mainPresenter.onClick(view);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
