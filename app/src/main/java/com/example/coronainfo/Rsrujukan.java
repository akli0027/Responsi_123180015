package com.example.coronainfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coronainfo.adapter.RsAdapter;
import com.example.coronainfo.api.ResponseRS;
import com.example.coronainfo.api.ResponeDataRs;
import com.example.coronainfo.service.ApiCovid;
import com.example.coronainfo.service.CovidInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Rsrujukan extends Fragment {

    private RecyclerView recyclerView;
    private RsAdapter adapter;
    private List<ResponeDataRs> listRS = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rsrujukan, container, false);
        recyclerView = view.findViewById(R.id.lv_rs);

        setRSData();
        return view;
    }

    private void setRSData(){
        CovidInterface apiInterface = ApiCovid.getClient().create(CovidInterface.class);

        Call<ResponseRS> call = apiInterface.getListRS();
        call.enqueue(new Callback<ResponseRS>() {
            @Override
            public void onResponse(Call<ResponseRS> call, Response<ResponseRS> response) {
                if (response.code()==200){
                    listRS = response.body().getData();
                    adapter = new RsAdapter(getContext(), listRS);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseRS> call, Throwable t) {

            }
        });
    }
}