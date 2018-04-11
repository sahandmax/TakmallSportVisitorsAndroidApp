package com.takmallsport.takmallsportvisitorsapp.ui.Main;

import android.content.Intent;
import android.view.View;

import com.takmallsport.takmallsportvisitorsapp.R;
import com.takmallsport.takmallsportvisitorsapp.ui.ShopsList.ShopsListActivity;

/**
 * Created by sahand on 4/10/18.
 */

public class MainPresenterImpl implements MainPresenter{
    MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onClick(View view) {
        Class ActivityToStart = null;
        switch (view.getId()){
            case R.id.button_check_products:
                ActivityToStart = ShopsListActivity.class;
                break;
        }
        Intent intent = new Intent(mainView.getContext(),ActivityToStart);
        mainView.getContext().startActivity(intent);
    }
}
