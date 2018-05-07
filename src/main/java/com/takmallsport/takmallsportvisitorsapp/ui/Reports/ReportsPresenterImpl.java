package com.takmallsport.takmallsportvisitorsapp.ui.Reports;

import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.adapter.reportAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.change;
import com.takmallsport.takmallsportvisitorsapp.ui.Reports.Interactors.ReportsInteractor;
import com.takmallsport.takmallsportvisitorsapp.ui.Reports.Interactors.ReportsInteractorImpl;

/**
 * Created by sahand on 4/29/18.
 */

public class ReportsPresenterImpl implements ReportsPresenter , ReportsInteractor.Listener{

    ReportsView view;
    ReportsInteractor report;

    public ReportsPresenterImpl(ReportsView view) {
        this.view = view;
        report = new ReportsInteractorImpl(this);
    }


    @Override
    public void onCrete() {
        report.LoadAllReports();
    }

    @Override
    public void removeChange(change report, int position) {
        this.report.removeChange(report,position);
    }

    @Override
    public void setDataIntoView(reportAdapter adapter) {
        view.setDataIntoView(adapter);
    }

    @Override
    public Activity getActivity() {
        return view.getActivity();
    }


    @Override
    public void questionDeleteReport(change report,int position) {
        view.questionDeleteReport(report,position);
    }
}
