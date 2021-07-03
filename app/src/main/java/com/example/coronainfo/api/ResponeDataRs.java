package com.example.coronainfo.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponeDataRs {
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("rujukan")
    @Expose
    private Object rujukan;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("url")
    @Expose
    private Object url;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Object getRujukan() {
        return rujukan;
    }

    public void setRujukan(Object rujukan) {
        this.rujukan = rujukan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
