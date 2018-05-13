package com.takmallsport.takmallsportvisitorsapp.ui.Main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.util.StoragePermisssions;

public class MainActivity extends AppCompatActivity implements  MainView, View.OnClickListener {
    Button button_check_products;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresenter = new MainPresenterImpl(this);
        while (! new StoragePermisssions().checkAndRequestPermissions(this)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        findViewById(R.id.button_check_products).setOnClickListener(this);
        findViewById(R.id.button_search_a_product).setOnClickListener(this);
        findViewById(R.id.button_connect_to_computer).setOnClickListener(this);
        findViewById(R.id.button_change_report).setOnClickListener(this);
        findViewById(R.id.button_about_application).setOnClickListener(this);
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
