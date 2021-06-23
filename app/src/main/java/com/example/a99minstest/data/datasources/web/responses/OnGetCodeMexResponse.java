package com.example.a99minstest.data.datasources.web.responses;

import com.example.a99minstest.data.pojos.FederalEntity;
import com.example.a99minstest.data.pojos.Municipality;
import com.example.a99minstest.data.pojos.Settlement;
import com.example.a99minstest.data.pojos.SettlementType;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OnGetCodeMexResponse {

    @SerializedName("zip_code")
    @Expose
    private String zipCode;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("federal_entity")
    @Expose
    private FederalEntity federalEntity;
    @SerializedName("settlements")
    @Expose
    private List<Settlement> settlements = null;
    @SerializedName("municipality")
    @Expose
    private Municipality municipality;

    public OnGetCodeMexResponse() {
        super();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public FederalEntity getFederalEntity() {
        return federalEntity;
    }

    public void setFederalEntity(FederalEntity federalEntity) {
        this.federalEntity = federalEntity;
    }

    public List<Settlement> getSettlements() {
        return settlements;
    }

    public void setSettlements(List<Settlement> settlements) {
        this.settlements = settlements;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
}
