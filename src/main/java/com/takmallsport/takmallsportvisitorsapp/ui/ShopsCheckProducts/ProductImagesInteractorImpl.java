package com.takmallsport.takmallsportvisitorsapp.ui.ShopsCheckProducts;

import android.os.Environment;
import android.widget.ImageView;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

import java.io.File;
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
        Images = new ArrayList<>(Arrays.asList(file));
        position = 0;
    }

    @Override
    public void LoadImageOnImageView() {
        File image_file = Images.get(position);
        listener.LoadImageOnImageView(image_file.getPath());
    }


    @Override
    public void NextPhoto() {
        position = position + 1;
        if (position >= (Images.size() - 1) ) {
            position = 0;
        }
    }

    @Override
    public int getImagesSize() {
        return Images.size();
    }


}
