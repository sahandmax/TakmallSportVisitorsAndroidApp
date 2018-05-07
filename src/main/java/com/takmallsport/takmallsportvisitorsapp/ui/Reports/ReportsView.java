package com.takmallsport.takmallsportvisitorsapp.ui.Reports;


import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.adapter.reportAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.change;

/**
 * Created by sahand on 4/29/18.
 */

public interface ReportsView {
    void setDataIntoView(reportAdapter adapter);
    Activity getActivity();
    void questionDeleteReport(change report, int position);
}
