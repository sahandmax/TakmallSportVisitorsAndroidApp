package com.takmallsport.takmallsportvisitorsapp.ui.FoundProduct.Interactors;

import android.app.Activity;

import com.takmallsport.takmallsportvisitorsapp.model.relations;

/**
 * Created by sahand on 4/28/18.
 */

public interface FoundProductInteractor {
    void getDetails();
    interface Listener {
        Activity getActivity();
        void LoadDetail(String text);
        void LoadImagesList(relations relations);
    }
}
