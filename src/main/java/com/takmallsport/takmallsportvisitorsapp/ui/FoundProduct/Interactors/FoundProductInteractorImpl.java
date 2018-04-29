package com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct.Interactors;

import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;

/**
 * Created by sahand on 4/28/18.
 */

public class FoundProductInteractorImpl implements FoundProductInteractor {

    relations relation;
    FoundProductInteractor.Listener listener;
    Context context;
    MainDbHelper mainDbHelper;

    public FoundProductInteractorImpl( Listener listener) {
        this.relation = (relations) listener.getActivity().getIntent().getSerializableExtra("relation");
        this.listener = listener;
        this.context = listener.getActivity();
        mainDbHelper = new MainDbHelper(context);

    }

    @Override
    public void getDetails() {
        shops shop = mainDbHelper.getShopFromRelation(relation);
        listener.LoadDetail(context.getString(R.string.ProductDetailsText)
                .replace("%sku%",relation.getSku())
                .replace("%code%",relation.getCode())
                .replace("%stock%",relation.getStock())
                .replace("%shopname%",relation.getShopname())
                .replace("%telephone%",shop.getTelephone())
                .replace("%address%",shop.getAddress()));
        listener.LoadImagesList(relation);
    }
}
