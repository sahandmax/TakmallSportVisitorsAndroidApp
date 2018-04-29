package com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations;

import android.app.Activity;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.adapter.variationAdapter;
import com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations.Interactors.CheckPriceAndVariationsInteractor;
import com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations.Interactors.CheckPriceAndVariationsInteractorImpl;

/**
 * Created by sahand on 4/22/18.
 */

public class CheckPriceAndVariationsPresenterImpl implements  CheckPriceAndVariationsPresenter , CheckPriceAndVariationsInteractor.Listener{
    CheckPricesAndVariationsView checkPricesAndVariationsView;
    CheckPriceAndVariationsInteractor checkPriceAndVariationsInteractor;

    public CheckPriceAndVariationsPresenterImpl(CheckPricesAndVariationsView checkPricesAndVariationsView) {
        this.checkPricesAndVariationsView = checkPricesAndVariationsView;
        checkPriceAndVariationsInteractor = new CheckPriceAndVariationsInteractorImpl(this);
    }

    @Override
    public void onCreate() {
        checkPriceAndVariationsInteractor.LoadVariations();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_saveChanges:
                checkPriceAndVariationsInteractor.SaveChanges();
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return checkPricesAndVariationsView.getActivity();
    }

    @Override
    public void LoadVariationsDataIntoRecycler(variationAdapter variationAdapter) {
        checkPricesAndVariationsView.LoadVariationsDataIntoRecycler(variationAdapter);
    }

    @Override
    public String getPrice() {
        return checkPricesAndVariationsView.getPrice();
    }

    @Override
    public void FinishActivity() {
        checkPricesAndVariationsView.FinishActivity();
    }
}
