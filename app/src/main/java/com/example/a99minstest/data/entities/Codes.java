package com.example.a99minstest.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Codes")
public class Codes {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Latitud")
    private double Latitud;

    @ColumnInfo(name = "Longitud")
    private double Longitud;

    public Codes() {
    }

    @Ignore
    public Codes(double latitud, double longitud) {
        Latitud = latitud;
        Longitud = longitud;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }
}
