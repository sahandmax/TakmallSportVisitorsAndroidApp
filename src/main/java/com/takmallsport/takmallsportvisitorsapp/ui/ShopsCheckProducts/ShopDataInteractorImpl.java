package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.widget.Toast;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sahand on 4/17/18.
 */

public class ShopDataInteractorImpl implements ShopDataInteractor {
    ShopDataInteractor.Listener listener;
    Context context;
    MainDbHelper mainDb;
    ArrayList<relations> relations;
    shops shop;
    int position;

    public ShopDataInteractorImpl(Listener listener) {
        this.listener = listener;
        context = listener.getActivity();
        mainDb = new MainDbHelper(listener.getActivity());
    }

    public void getShopDatas() {
        position = 0;
        Intent intent = listener.getActivity().getIntent();
        shop = (shops) intent.getSerializableExtra("shop");
        relations = mainDb.getRelationsFromShop(shop);
        if (relations.size() == 0) {
            Toast.makeText(context,context.getString(R.string.at_this_shop_we_not_have_products),Toast.LENGTH_SHORT).show();
            listener.getActivity().finish();
        }
    }

    public void getDataForDetail() {
        com.takmallsport.takmallsportvisitorsapp.model.relations relation = relations.get(position);
        listener.LoadDetail(context.getString(R.string.ProductDetailsText)
                .replace("%sku%",relation.getSku())
                .replace("%code%",relation.getCode())
                .replace("%stock%",relation.getStock())
                .replace("%shopname%",relation.getShopname())
                .replace("%telephone%",shop.getTelephone())
                .replace("%address%",shop.getAddress()));
        listener.LoadImagesList(relation);
        setTextviewPageSize();
    }
    public void nextProduct() {
        position = position + 1;
        if (position > (relations.size() - 1))
            listener.AlertFinishOfProducts();
        else
        getDataForDetail();
    }

    @Override
    public void prevProduct() {
        position = position - 1;
        if (position < 0) {
            position = 0;
            listener.ToastYouAreAtFirstOfProducts();
        }
        else
            getDataForDetail();
    }

    @Override
    public int getProductsSize() {
        return relations.size();
    }

    private void setTextviewPageSize() {
        listener.setTextviewPageSize((position + 1)+ "/" + relations.size());
    }
}
