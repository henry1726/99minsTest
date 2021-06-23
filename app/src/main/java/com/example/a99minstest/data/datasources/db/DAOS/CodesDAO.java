package com.example.a99minstest.data.datasources.db.DAOS;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.a99minstest.data.entities.Codes;
import com.example.a99minstest.data.pojos.Coordenada;

import java.util.List;

@Dao
public interface CodesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCodes(List<Codes> list);

    @Query("SELECT * FROM Codes")
    LiveData<List<Codes>> readAll();

    @Query("DELETE FROM Codes" )
    void truncate();

}
