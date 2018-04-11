package com.takmallsport.takmallsportvisitorsapp.ui.ShopsList;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;

public class ShopsListActivity extends AppCompatActivity implements ShopsListView {
    ShopsListPresenter shopsListPresenter;
    RecyclerView recycler_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops_list);
        shopsListPresenter = new ShopsListPresenterImpl(this);
        recycler_main = findViewById(R.id.recycler_main);
        shopsListPresenter.onCreate();
    }

    @Override
    public void setDataToRecycler(shopsAdapter adapter) {
        recycler_main.setLayoutManager(new LinearLayoutManager(this));
        recycler_main.setAdapter(adapter);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
