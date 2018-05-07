package com.takmallsport.takmallsportvisitorsapp.ui.Reports;

import com.takmallsport.takmallsportvisitorsapp.model.change;

/**
 * Created by sahand on 4/29/18.
 */

public interface ReportsPresenter {
    void onCrete();
    void removeChange(change report , int position);
}
