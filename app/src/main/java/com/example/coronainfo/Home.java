package com.example.coronainfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.coronainfo.adapter.CoronaAdapter;
import com.example.coronainfo.api.Respone;
import com.example.coronainfo.api.ResponItemData;
import com.example.coronainfo.service.ApiCovid;
import com.example.coronainfo.service.CovidInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Home extends Fragment {

    private RecyclerView recyclerView;
    private CoronaAdapter adapter;
    private List<ResponItemData> listCovid = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.lv_item);
        setCovidData();
        return view;
    }

    private void setCovidData(){
        CovidInterface covidInterface = ApiCovid.getClient().create(CovidInterface.class);

        Call<Respone> call = covidInterface.getListCovid();
        call.enqueue(new Callback<Respone>() {
            @Override
            public void onResponse(Call<Respone> call, Response<Respone> response) {
                if (response.code()==200){

                    listCovid = response.body().getData().getContent();
                    adapter = new CoronaAdapter(getContext(), listCovid);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    Collections.reverse(listCovid);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Respone> call, Throwable t) {

            }
        });
    }
}