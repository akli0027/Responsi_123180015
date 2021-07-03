package com.example.coronainfo.service;

import com.example.coronainfo.api.Respone;
import com.example.coronainfo.api.ResponseRS;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidInterface {

    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<Respone> getListCovid();

    @GET("sebaran_v2/jabar/faskes")
    Call<ResponseRS> getListRS();
}
