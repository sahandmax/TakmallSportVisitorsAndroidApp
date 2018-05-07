package com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct;

import android.app.Activity;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.model.relations;
import com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct.Interactors.FoundProductInteractor;
import com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct.Interactors.FoundProductInteractorImpl;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts.Interactors.ProductImagesInteractor;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts.Interactors.ProductImagesInteractorImpl;

/**
 * Created by sahand on 4/28/18.
 */

public class FoundProductPresenterImpl implements FoundProductPresenter,ProductImagesInteractor.Listener , FoundProductInteractor.Listener {

    FoundProductView view;
    FoundProductInteractor productInteractor;
    ProductImagesInteractor imagesInteractor;

    public FoundProductPresenterImpl(FoundProductView view) {
        this.view = view;
        productInteractor = new FoundProductInteractorImpl(this);
        imagesInteractor = new ProductImagesInteractorImpl(this);

    }


    @Override
    public void onCreate() {
        productInteractor.getDetails();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_product:
                imagesInteractor.NextPhoto();
                imagesInteractor.LoadImageOnImageView();
                break;
        }
    }

    @Override
    public void LoadImageOnImageView(String path) {
        view.LoadImageOnImageView(path);
    }

    @Override
    public Activity getActivity() {
        return view.getActivity();
    }

    @Override
    public void LoadDetail(String text) {
        view.LoadDetail(text);
    }

    @Override
    public void LoadImagesList(relations relation) {
        imagesInteractor.LoadImagesList(relation);
        imagesInteractor.LoadImageOnImageView();
    }
}
