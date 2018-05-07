package com.takmallsport.takmallsportvisitorsapp.ui.Reports.Interactors;

import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.adapter.reportAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.change;
import com.takmallsport.takmallsportvisitorsapp.util.db.VisitorDbHelper;

import java.util.ArrayList;

/**
 * Created by sahand on 4/29/18.
 */

public class ReportsInteractorImpl implements ReportsInteractor, reportAdapter.onClickListener {

    ReportsInteractor.Listener listener;
    reportAdapter adapter;
    VisitorDbHelper visitorDbHelper;
    ArrayList<change> changes;

    public ReportsInteractorImpl(Listener listener) {
        this.listener = listener;
        visitorDbHelper = new VisitorDbHelper(listener.getActivity());
    }


    @Override
    public void LoadAllReports() {
        changes = visitorDbHelper.GetAllChanges();
        adapter = new reportAdapter(changes,listener.getActivity());
        listener.setDataIntoView(adapter);
        adapter.setOnclickListener(this);
    }

    @Override
    public void removeChange(change report, int position) {
        visitorDbHelper.DeleteReport(report);
        changes.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public void Click(View view, int Position, int ViewType) {
        change report = changes.get(Position);
        switch (view.getId()) {
            case R.id.cardView_delete:
                listener.questionDeleteReport(report , Position);
                break;
        }
    }


}
