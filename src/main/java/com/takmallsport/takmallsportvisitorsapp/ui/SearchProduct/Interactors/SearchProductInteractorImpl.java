package com.takmallsport.takmallsportvisitorsapp.ui.SearchProduct.Interactors;

import android.content.Intent;

import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct.FoundProductActivity;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;

/**
 * Created by sahand on 4/23/18.
 */

public class SearchProductInteractorImpl implements  SearchProductInteractor {

    SearchProductInteractor.Listener listener;
    MainDbHelper mainDbHelper;

    public SearchProductInteractorImpl(Listener listener) {
        this.listener = listener;
        mainDbHelper = new MainDbHelper(listener.getActivity());
    }


    @Override
    public void ViewProduct(String sku) {
        relations relation = mainDbHelper.getRelationBySKU(sku);
        if (relation == null)
            listener.ProductNotFound();
        else {
            Intent intent = new Intent(listener.getActivity(), FoundProductActivity.class);
            intent.putExtra("relation",relation);
            listener.getActivity().startActivity(intent);
        }
    }
}
