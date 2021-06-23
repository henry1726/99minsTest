package com.example.a99minstest.data.datasources.web;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.a99minstest.data.datasources.web.api.WebService;
import com.example.a99minstest.data.datasources.web.responses.OnGetCodeMexResponse;
import com.example.a99minstest.data.datasources.web.responses.OnGetCodesResponse;
import com.example.a99minstest.data.entities.Codes;
import com.example.a99minstest.sys.di.components.DaggerFrameworkComponent;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CodesWeb {

    @Inject
    WebService webService;

    public CodesWeb() {
        DaggerFrameworkComponent.builder()
                .build().inject(this);
    }

    public void downloadCodes(Observer<OnGetCodesResponse> observer, Observer<String> observerError) {
        webService.getCodes().enqueue(new Callback<OnGetCodesResponse>() {
            @Override
            public void onResponse(Call<OnGetCodesResponse> call, Response<OnGetCodesResponse> response) {
                if(response.code() == 200){
                    observer.onChanged(response.body());
                    Log.i("DownloadCodes", "Gone!");
                }else{
                    observerError.onChanged("Error al descargar los polígonos del API: message: "+response.message() +" status:"+ response.code());
                    Log.e("DownloadCodesMex", "Error al descargar los datos del API: message: "+response.message() +" status:"+ response.code());
                }
            }

            @Override
            public void onFailure(Call<OnGetCodesResponse> call, Throwable t) {
                observerError.onChanged(t.getLocalizedMessage());
                Log.e("DownloadCodesFail", t.getLocalizedMessage());
            }
        });
    }


}
