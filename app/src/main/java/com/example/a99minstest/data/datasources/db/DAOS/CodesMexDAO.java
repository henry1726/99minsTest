package com.example.a99minstest.data.datasources.db.DAOS;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a99minstest.data.entities.CodesMex;

import java.util.List;

@Dao
public interface CodesMexDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCodes(CodesMex list);

    @Query("SELECT * FROM CodesMex")
    LiveData<CodesMex> readAll();

    @Query("DELETE FROM CodesMex" )
    void truncate();

}
