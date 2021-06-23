package com.example.a99minstest.data.datasources.db.declaration;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.a99minstest.data.datasources.db.DAOS.CodesDAO;
import com.example.a99minstest.data.datasources.db.DAOS.CodesMexDAO;
import com.example.a99minstest.data.entities.Codes;
import com.example.a99minstest.data.entities.CodesMex;

@Database(entities = {Codes.class,
                    CodesMex.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CodesDAO getCodesDAO();

    public abstract CodesMexDAO getCodesMexDAO();
}
