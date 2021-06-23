package com.example.a99minstest.sys.di.components;

import com.example.a99minstest.sys.di.modules.RepositoryModule;
import com.example.a99minstest.ui.main.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RepositoryModule.class)
public interface RepositoryComponent {

    void inject(MainActivityViewModel viewModel);

}
