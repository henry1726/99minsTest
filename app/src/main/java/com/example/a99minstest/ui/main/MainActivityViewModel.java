package com.example.a99minstest.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.a99minstest.data.entities.Codes;
import com.example.a99minstest.data.entities.CodesMex;
import com.example.a99minstest.domain.CodesRepository;
import com.example.a99minstest.sys.di.components.DaggerRepositoryComponent;

import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel {

    @Inject
    CodesRepository codesRepository;

    public MainActivityViewModel() {
        DaggerRepositoryComponent.builder()
                .build().inject(this);
    }

    public void downloadCodes(){
        codesRepository.downloadCodes();
    }

    public LiveData<List<Codes>> getCoordenadas(){
        return codesRepository.getCoordenadas();
    }

    public LiveData<CodesMex> getInfo(){
        return codesRepository.getInfo();
    }

    //public LiveData<>

    public void downloadCodesMex(){
         codesRepository.downloadCodesMex();
    }

}
