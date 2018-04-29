package com.takmallsport.takmallsportvisitorsapp.ui.Reports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.takmallsport.takmallsportvisitorsapp.R;

public class ReportsActivity extends AppCompatActivity implements ReportsView {

    ReportsPresenter presenter;
    RecyclerView recycler_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        presenter = new ReportsPresenterImpl(this);
        presenter.onCrete();
    }
}
