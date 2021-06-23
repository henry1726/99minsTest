package com.example.a99minstest.domain;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.a99minstest.MainApplication;
import com.example.a99minstest.data.datasources.db.DAOS.CodesDAO;
import com.example.a99minstest.data.datasources.db.DAOS.CodesMexDAO;
import com.example.a99minstest.data.datasources.web.CodesMexWeb;
import com.example.a99minstest.data.datasources.web.CodesWeb;
import com.example.a99minstest.data.datasources.web.responses.OnGetCodeMexResponse;
import com.example.a99minstest.data.datasources.web.responses.OnGetCodesResponse;
import com.example.a99minstest.data.entities.Codes;
import com.example.a99minstest.data.entities.CodesMex;
import com.example.a99minstest.sys.di.components.DaggerDataSourceComponent;
import com.example.a99minstest.sys.di.modules.ContextModule;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class CodesRepository {

    @Inject
    CodesWeb codesWeb;

    @Inject
    CodesMexWeb codesMexWeb;

    @Inject
    CodesDAO codesDAO;

    @Inject
    CodesMexDAO codesMexDAO;

    private List<Codes> mList = new ArrayList<>();

    public CodesRepository(){
        DaggerDataSourceComponent.builder()
                .contextModule(new ContextModule(MainApplication.getAppContext()))
                .build().inject(this);
    }

    public LiveData<List<Codes>> getCoordenadas(){
        return codesDAO.readAll();
    }

    public LiveData<CodesMex> getInfo(){
        return codesMexDAO.readAll();
    }

    public void downloadCodes(){
        codesWeb.downloadCodes(buildCodesObserver(), buildCodesMexObserverError());
    }

    public Observer<OnGetCodesResponse> buildCodesObserver(){
        return result -> {
            if(result != null){
                codesDAO.truncate();
                List<ArrayList<Double>> list = result.getGeometry().coordinates.get(0);
                for (ArrayList<Double> coordenada : list){
                    Codes codes = new Codes(coordenada.get(1), coordenada.get(0));
                    mList.add(codes);
                }
                codesDAO.insertCodes(mList);
            }
        };
    }

    public void downloadCodesMex(){
      codesMexWeb.dowloadCodesMex(buildCodesMexObserver(), buildCodesMexObserverError());
    }

    public Observer<OnGetCodeMexResponse> buildCodesMexObserver(){
        return result ->{
          if(result != null){
              codesMexDAO.truncate();
              CodesMex codesMex = new CodesMex(result.getZipCode(), result.getLocality(), result.getFederalEntity().getName(), result.getMunicipality().getName(),
                      result.getSettlements().get(0).getName());
              codesMexDAO.insertCodes(codesMex);

          }
        };
    }

    public Observer<String> buildCodesMexObserverError(){
        return e -> {
            if(!e.isEmpty()){
                Toast.makeText(MainApplication.getAppContext(), e, Toast.LENGTH_LONG).show();
            }
        };
    }

}
