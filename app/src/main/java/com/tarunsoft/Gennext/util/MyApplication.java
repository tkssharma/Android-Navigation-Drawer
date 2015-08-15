package com.tarunsoft.Gennext.util;

import android.app.Application;
import android.content.Context;

/**
 * Created by tsharma3 on 8/15/2015.
 */
public class MyApplication extends Application {

    private static Context context;

    public void onCreate(){
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}