package com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations.Interactors;

import android.content.Intent;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.adapter.variationAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.model.variation;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;
import com.takmallsport.takmallsportvisitorsapp.util.db.VisitorDbHelper;

import java.util.ArrayList;

/**
 * Created by sahand on 4/23/18.
 */

public class CheckPriceAndVariationsInteractorImpl implements  CheckPriceAndVariationsInteractor, com.takmallsport.takmallsportvisitorsapp.adapter.variationAdapter.onClickListener {

    CheckPriceAndVariationsInteractor.Listener listener;
    Intent intent;
    MainDbHelper mainDbHelper;
    VisitorDbHelper visitorDbHelper;
    variationAdapter variationAdapter;
    ArrayList<variation> variations;
    relations relation;


    public CheckPriceAndVariationsInteractorImpl(Listener listener) {
        this.listener = listener;
        intent = listener.getActivity().getIntent();
        mainDbHelper = new MainDbHelper(listener.getActivity());
        visitorDbHelper = new VisitorDbHelper(listener.getActivity());
    }

    @Override
    public void LoadVariations() {
        relation = (relations) intent.getSerializableExtra("relation");
        variations = mainDbHelper.getVariationList(relation);
        variationAdapter = new variationAdapter(variations , listener.getActivity());
        listener.LoadVariationsDataIntoRecycler(variationAdapter);
        variationAdapter.setOnClickListener(this);
    }

    @Override
    public void SaveChanges() {
        if (!listener.getPrice().equals(""))
            visitorDbHelper.ChangePrice(relation.getSku(),listener.getPrice(),listener.getActivity());
        for (variation variation : variations) {
            if (!variation.isStock()) {
                visitorDbHelper.InsertVariationWithNoStock(relation.getSku(), variation, listener.getActivity());
                mainDbHelper.DeleteVariation(relation.getSku(),variation);
            }
        }
        listener.FinishActivity();
    }

    @Override
    public void onClick(View view, int position, int viewType) {
        variation variation = variations.get(position);
        variation.setStock(!variation.isStock());
        variations.set(position,variation);
        variationAdapter.notifyItemChanged(position);

    }
}
