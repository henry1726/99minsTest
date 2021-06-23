package com.example.a99minstest.data.pojos;

import com.example.a99minstest.data.entities.Codes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Geometry {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("coordinates")
    @Expose
    public List<List<ArrayList<Double>>> coordinates = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<List<ArrayList<Double>>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<ArrayList<Double>>> coordinates) {
        this.coordinates = coordinates;
    }
}
