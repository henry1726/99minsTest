package com.example.a99minstest.data.datasources.web;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.a99minstest.data.datasources.web.api.WebService2;
import com.example.a99minstest.data.datasources.web.responses.OnGetCodeMexResponse;
import com.example.a99minstest.sys.di.components.DaggerFramework2Component;
import com.example.a99minstest.sys.di.components.DaggerFrameworkComponent;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CodesMexWeb {

    @Inject
    WebService2 webService;

    public CodesMexWeb() {
        DaggerFramework2Component.builder()
                .build().inject(this);
    }


    public void dowloadCodesMex(Observer<OnGetCodeMexResponse> observer, Observer<String> observerError){
        webService.getCodesMex().enqueue(new Callback<OnGetCodeMexResponse>() {
            @Override
            public void onResponse(Call<OnGetCodeMexResponse> call, Response<OnGetCodeMexResponse> response) {
                if(response.code() == 200){
                    observer.onChanged(response.body());
                    Log.i("DownloadCodesMex", "Gone!");
                }else{
                    observerError.onChanged("Error al descargar la información del CP del API: message: "+response.message() +" status:"+ response.code());
                    Log.e("DownloadCodesMex", "Error al descargar los datos del API: message: "+response.message() +" status:"+ response.code());
                }
            }

            @Override
            public void onFailure(Call<OnGetCodeMexResponse> call, Throwable t) {
                observerError.onChanged(t.getLocalizedMessage());
                Log.e("DownloadCodesMexFail", t.getLocalizedMessage());
            }
        });
    }
}
