package com.takmallsport.takmallsportvisitorsapp.ui.Reports;

import com.takmallsport.takmallsportvisitorsapp.ui.Reports.Interactors.ReportsInteractor;

/**
 * Created by sahand on 4/29/18.
 */

public class ReportsPresenterImpl implements ReportsPresenter , ReportsInteractor.Listener{

    ReportsView view;

    public ReportsPresenterImpl(ReportsView view) {
        this.view = view;
    }


}
