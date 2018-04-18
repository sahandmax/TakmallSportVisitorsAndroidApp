package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

/**
 * Created by sahand on 4/11/18.
 */

public interface ShopCheckProductsView {
    Activity getActivity();
    void LoadDetail(String detail);
    void LoadImageOnImageView(String path);
    void VisibleDescription();
    void HideDescription();
    void AlertFinishOfProducts();
    void ToastYouAreAtFirstOfProducts();
    void setTextviewPageSize(String text);
}
