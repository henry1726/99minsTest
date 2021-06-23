package com.example.a99minstest.sys.di.modules;

import android.content.Context;

import androidx.room.Room;

import com.example.a99minstest.data.datasources.db.declaration.AppDatabase;
import com.example.a99minstest.sys.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class DatabaseModule {

    @Singleton
    @Provides
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, Constants.Db.DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

}
