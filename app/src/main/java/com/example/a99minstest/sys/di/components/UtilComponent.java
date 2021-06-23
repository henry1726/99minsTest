package com.example.a99minstest.sys.di.components;

import android.content.Context;

import com.example.a99minstest.sys.di.modules.UtilModule;
import com.example.a99minstest.sys.providers.AppExecutors;
import com.example.a99minstest.sys.providers.ResourceProvider;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UtilModule.class)
public interface UtilComponent {

    Context getAppContext();

    AppExecutors getAppExecutors();

    ResourceProvider getResourceProvider();
}
