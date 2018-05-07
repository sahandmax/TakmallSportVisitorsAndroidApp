package com.takmallsport.takmallsportvisitorsapp.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by sahand on 5/7/18.
 */

public class ApplicationClass extends Application {
    private static Context context;
    public static Context getContext() {
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
