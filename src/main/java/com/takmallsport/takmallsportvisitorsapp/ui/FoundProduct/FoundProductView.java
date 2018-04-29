package com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct;

import android.app.Activity;

/**
 * Created by sahand on 4/28/18.
 */

public interface FoundProductView {
    Activity getActivity();
    void LoadImageOnImageView(String path);
    void LoadDetail(String text);
}
