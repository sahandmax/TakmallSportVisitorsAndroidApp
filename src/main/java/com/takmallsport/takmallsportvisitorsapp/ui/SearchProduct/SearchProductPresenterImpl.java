package com.takmallsport.takmallsportvisitorsapp.ui.SearchProduct;

import android.app.Activity;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.ui.SearchProduct.Interactors.SearchProductInteractor;
import com.takmallsport.takmallsportvisitorsapp.ui.SearchProduct.Interactors.SearchProductInteractorImpl;

/**
 * Created by sahand on 4/23/18.
 */

public class SearchProductPresenterImpl implements  SearchProductPresenter , SearchProductInteractor.Listener {

    SearchProductInteractor searchProductInteractor;

    public SearchProductPresenterImpl(SearchProductView searchProductView) {
        this.searchProductView = searchProductView;
        searchProductInteractor = new SearchProductInteractorImpl(this);
    }

    SearchProductView searchProductView;


    @Override
    public void onCreate() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_search:
                searchProductInteractor.ViewProduct(searchProductView.getSearchValue());
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return searchProductView.getActivity();
    }

    @Override
    public void ProductNotFound() {
        searchProductView.ProductNotFound();
    }
}
