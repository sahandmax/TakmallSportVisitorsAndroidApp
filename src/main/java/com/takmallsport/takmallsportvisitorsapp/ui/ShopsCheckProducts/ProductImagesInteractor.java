package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by sahand on 4/17/18.
 */

public interface ProductImagesInteractor {
    void LoadImagesList(relations relation);
    void LoadImageOnImageView();
    void NextPhoto();
    int getImagesSize();
    interface Listener {
        void LoadImageOnImageView(String path);
    }

}
