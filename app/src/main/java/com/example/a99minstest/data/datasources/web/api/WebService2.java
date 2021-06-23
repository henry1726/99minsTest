package com.example.a99minstest.data.datasources.web.api;

import com.example.a99minstest.data.datasources.web.responses.OnGetCodeMexResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService2 {

    @GET("api/zip-codes/01210")
    Call<OnGetCodeMexResponse> getCodesMex();
}
