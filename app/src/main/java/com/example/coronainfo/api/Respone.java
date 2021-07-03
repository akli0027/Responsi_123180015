package com.example.coronainfo.api;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Respone {
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("data")
    @Expose
    private ResponData data;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ResponData getData() {
        return data;
    }

    public void setData(ResponData data) {
        this.data = data;
    }
}
