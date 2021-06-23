package com.example.a99minstest.sys.di.components;

import com.example.a99minstest.data.datasources.web.CodesMexWeb;
import com.example.a99minstest.data.datasources.web.CodesWeb;
import com.example.a99minstest.sys.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = NetworkModule.class)
public interface FrameworkComponent {

    void inject(CodesWeb codesWeb);

}