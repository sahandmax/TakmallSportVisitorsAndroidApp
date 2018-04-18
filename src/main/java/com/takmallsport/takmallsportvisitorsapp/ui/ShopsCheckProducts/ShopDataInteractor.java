package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;
import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by sahand on 4/17/18.
 */

public interface ShopDataInteractor {

    void getShopDatas();
    void getDataForDetail();
    int getProductsSize();
    void nextProduct();
    void prevProduct();
    interface Listener {
        Activity getActivity();
        void LoadDetail(String detail);
        void LoadImagesList(relations relation);
        void AlertFinishOfProducts();
        void ToastYouAreAtFirstOfProducts();
        void setTextviewPageSize(String text);

    }
}
