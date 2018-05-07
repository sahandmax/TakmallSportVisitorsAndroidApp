package com.takmallsport.takmallsportvisitorsapp.ui.Reports;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.adapter.reportAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.change;

public class ReportsActivity extends AppCompatActivity implements ReportsView {

    ReportsPresenter presenter;
    RecyclerView recycler_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        recycler_main = findViewById(R.id.recycler_main);
        presenter = new ReportsPresenterImpl(this);
        presenter.onCrete();
    }

    @Override
    public void setDataIntoView(reportAdapter adapter) {
        recycler_main.setLayoutManager(new LinearLayoutManager(this));
        recycler_main.setAdapter(adapter);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void questionDeleteReport(final change report , final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle(R.string.delete_change)
                .setMessage(getString(R.string.do_you_want_to_delete_)
                        .replace("%V%" , report.getReport()))
                .setNegativeButton(R.string.no , null)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        presenter.removeChange(report,position);
                    }
                });
        builder.show();
    }
}
