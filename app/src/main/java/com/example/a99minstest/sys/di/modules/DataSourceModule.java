package com.example.a99minstest.sys.di.modules;



import com.example.a99minstest.data.datasources.db.DAOS.CodesDAO;
import com.example.a99minstest.data.datasources.db.DAOS.CodesMexDAO;
import com.example.a99minstest.data.datasources.db.declaration.AppDatabase;
import com.example.a99minstest.data.datasources.web.CodesMexWeb;
import com.example.a99minstest.data.datasources.web.CodesWeb;
import com.example.a99minstest.data.entities.CodesMex;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(includes = DatabaseModule.class)
public class DataSourceModule {

    @Singleton
    @Provides
    CodesWeb provideCodesWeb() {
        return new CodesWeb();
    }

    @Singleton
    @Provides
    CodesMexWeb provideCodesMexWeb() {
        return new CodesMexWeb();
    }

    @Singleton
    @Provides
    CodesDAO provideCodesDAO(AppDatabase database) {
        return database.getCodesDAO();
    }

    @Singleton
    @Provides
    CodesMexDAO provideCodesMexDAO(AppDatabase database) {
        return database.getCodesMexDAO();
    }

}