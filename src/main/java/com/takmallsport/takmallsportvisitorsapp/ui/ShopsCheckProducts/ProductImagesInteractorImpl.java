package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.app.Application;
import android.os.Environment;
import android.widget.ImageView;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sahand on 4/17/18.
 */

public class ProductImagesInteractorImpl implements ProductImagesInteractor {
    ArrayList<File> Images = new ArrayList<>();
    int position;
    ProductImagesInteractor.Listener listener;

    public ProductImagesInteractorImpl(Listener listener) {
        this.listener = listener;
    }



    public void LoadImagesList(relations relation) {
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "/images/" + File.separator + relation.getSku() + File.separator + "/" );
        try {
            Images = new ArrayList<>(Arrays.asList(file.listFiles()));
        } catch (Exception e) {
            Images = new ArrayList<>();
        }
        position = 0;
    }

    @Override
    public void LoadImageOnImageView() {
        File image_file;
        try {
             image_file = Images.get(position);
        } catch (Exception e) {
            image_file = new File("android.resource://com./drawable/icon");
        }


            listener.LoadImageOnImageView(image_file.getAbsolutePath());

    }


    @Override
    public void NextPhoto() {
        position = position + 1;
        if (position > (Images.size() - 1) ) {
            position = 0;
        }
    }

    @Override
    public int getImagesSize() {
        return Images.size();
    }


}
