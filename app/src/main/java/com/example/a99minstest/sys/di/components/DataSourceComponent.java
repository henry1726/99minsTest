package com.example.a99minstest.sys.di.components;


import com.example.a99minstest.domain.CodesRepository;
import com.example.a99minstest.sys.di.modules.DataSourceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DataSourceModule.class)
public interface DataSourceComponent {

    void inject(CodesRepository repository);


}