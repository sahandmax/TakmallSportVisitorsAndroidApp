package com.takmallsport.takmallsportvisitorsapp.ui.ShopListActivity;

import android.content.Context;

import com.takmallsport.takmallsportvisitorsapp.adapter.shopsAdapter;
import com.takmallsport.takmallsportvisitorsapp.model.shops;

import java.util.ArrayList;

/**
 * Created by sahand on 4/10/18.
 */

public interface ShopsListView {
    void setDataToRecycler(shopsAdapter adapter);
    Context getContext();
}
