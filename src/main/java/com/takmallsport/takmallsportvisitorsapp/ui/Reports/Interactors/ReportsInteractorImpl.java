package com.takmallsport.takmallsportvisitorsapp.ui.Reports.Interactors;

/**
 * Created by sahand on 4/29/18.
 */

public class ReportsInteractorImpl implements ReportsInteractor {

    ReportsInteractor.Listener listener;

    public ReportsInteractorImpl(Listener listener) {
        this.listener = listener;
    }


}
