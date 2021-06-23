package com.example.a99minstest.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "CodesMex")
public class CodesMex {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "Codigo_postal")
    private String codigoPostal;

    @ColumnInfo(name = "Entidad")
    private String entidad;

    @ColumnInfo(name = "Ciudad")
    private String ciudad;

    @ColumnInfo(name = "Alcaldia")
    private String alcaldia;

    @ColumnInfo(name = "Colonia")
    private String colonia;

    public CodesMex() {
    }

    @Ignore
    public CodesMex(String codigoPostal, String entidad, String ciudad, String alcaldia, String colonia) {
        this.codigoPostal = codigoPostal;
        this.entidad = entidad;
        this.ciudad = ciudad;
        this.alcaldia = alcaldia;
        this.colonia = colonia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAlcaldia() {
        return alcaldia;
    }

    public void setAlcaldia(String alcaldia) {
        this.alcaldia = alcaldia;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
}
