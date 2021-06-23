package com.example.a99minstest.data.datasources.web.responses;

import com.example.a99minstest.data.entities.Codes;
import com.example.a99minstest.data.pojos.Coordenada;
import com.example.a99minstest.data.pojos.Geometry;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import okhttp3.Response;

public class OnGetCodesResponse {

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("geometry")
    @Expose
    private Geometry geometry;

    public OnGetCodesResponse() {
        super();
    }

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
