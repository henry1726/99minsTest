package com.example.a99minstest.sys.di.modules;

import com.example.a99minstest.domain.CodesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class RepositoryModule {

    @Singleton
    @Provides
    CodesRepository provideLoggedUserRepository() {
        return new CodesRepository();
    }
}