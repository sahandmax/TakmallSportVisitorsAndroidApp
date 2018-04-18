package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.model.shops;
import com.takmallsport.takmallsportvisitorsapp.util.db.MainDbHelper;

import java.util.ArrayList;

/**
 * Created by sahand on 4/11/18.
 */

public class ShopCheckProductsPresenterImpl implements  ShopCheckProductsPresenter , ShopDataInteractor.Listener , ProductImagesInteractor.Listener{
    ShopCheckProductsView shopCheckProductsView;
    ShopDataInteractor shopDataInteractor;
    ProductImagesInteractor productImagesInteractor;




    public ShopCheckProductsPresenterImpl(ShopCheckProductsView shopCheckProductsView) {
        this.shopCheckProductsView = shopCheckProductsView;
        shopDataInteractor = new ShopDataInteractorImpl(this);
        productImagesInteractor = new ProductImagesInteractorImpl(this);
    }


    @Override
    public void onCreate() {

        shopDataInteractor.getShopDatas();
        if (shopDataInteractor.getProductsSize() != 0 )
        shopDataInteractor.getDataForDetail();
        if (productImagesInteractor.getImagesSize() > 0 )
            productImagesInteractor.LoadImageOnImageView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_back:
                shopDataInteractor.prevProduct();
                productImagesInteractor.LoadImageOnImageView();
                break;
            case R.id.button_not_have:

                break;
            case R.id.button_next:
                shopDataInteractor.nextProduct();
                productImagesInteractor.LoadImageOnImageView();
                break;
            case R.id.image_product:
                shopCheckProductsView.HideDescription();
                productImagesInteractor.NextPhoto();
                productImagesInteractor.LoadImageOnImageView();
                break;

        }
    }

    @Override
    public void onLongClick(View view) {
        switch (view.getId()){
            case R.id.image_product:
                shopCheckProductsView.VisibleDescription();
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return shopCheckProductsView.getActivity();
    }

    @Override
    public void LoadDetail(String detail) {
        shopCheckProductsView.LoadDetail(detail);
    }

    @Override
    public void LoadImagesList(relations relation) {
        productImagesInteractor.LoadImagesList(relation);
    }

    @Override
    public void AlertFinishOfProducts() {
        shopCheckProductsView.AlertFinishOfProducts();
    }

    @Override
    public void ToastYouAreAtFirstOfProducts() {
        shopCheckProductsView.ToastYouAreAtFirstOfProducts();
    }

    @Override
    public void setTextviewPageSize(String text) {
        shopCheckProductsView.setTextviewPageSize(text);
    }


    @Override
    public void LoadImageOnImageView(String path) {
        shopCheckProductsView.LoadImageOnImageView(path);
    }
}
