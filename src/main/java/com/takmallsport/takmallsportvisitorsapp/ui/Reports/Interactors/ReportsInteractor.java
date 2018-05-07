package com.takmallsport.takmallsportvisitorsapp.ui.Reports.Interactors;

import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.adapter.reportAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.change;

/**
 * Created by sahand on 4/29/18.
 */

public interface ReportsInteractor {
    void LoadAllReports();
    void removeChange(change report , int position);
    interface Listener {
        void setDataIntoView(reportAdapter adapter);
        Activity getActivity();
        void questionDeleteReport(change report,int position);
    }
}
