package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts.Interactors;

import android.content.Intent;

import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.ui.CheckPricesAndVariations.CheckPricesAndVariationsActivity;

/**
 * Created by sahand on 4/22/18.
 */

public class ShopCheckProductsIntentsInteractorImpl implements ShopCheckProductsIntentsInteractor {

    ShopCheckProductsIntentsInteractorImpl.Listener listener;

    public ShopCheckProductsIntentsInteractorImpl(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void ChangePriceAndVariations(relations relation) {
        Intent i = new Intent(listener.getActivity(), CheckPricesAndVariationsActivity.class);
        i.putExtra("relation",relation);
        listener.getActivity().startActivity(i);
    }
}
