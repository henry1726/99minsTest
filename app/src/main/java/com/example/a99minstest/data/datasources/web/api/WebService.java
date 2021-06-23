package com.example.a99minstest.data.datasources.web.api;

import com.example.a99minstest.data.datasources.web.responses.OnGetCodeMexResponse;
import com.example.a99minstest.data.datasources.web.responses.OnGetCodesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET("zip-codes/01210/")
    Call<OnGetCodesResponse> getCodes();

}