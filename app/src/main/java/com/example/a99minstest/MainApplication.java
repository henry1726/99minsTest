package com.example.a99minstest;

import android.app.Application;
import android.content.Context;

import com.example.a99minstest.sys.di.components.DaggerUtilComponent;
import com.example.a99minstest.sys.di.components.UtilComponent;
import com.example.a99minstest.sys.di.modules.ContextModule;
import com.example.a99minstest.sys.providers.AppExecutors;
import com.example.a99minstest.sys.providers.ResourceProvider;

public class MainApplication extends Application {

    public static UtilComponent utilComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        utilComponent = DaggerUtilComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();

    }

    public static Context getAppContext() {
        return utilComponent.getAppContext();
    }

}
