package com.example.coronainfo.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponItemData {
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("kode_prov")
    @Expose
    private String kodeProv;
    @SerializedName("nama_prov")
    @Expose
    private String namaProv;
    @SerializedName("CONFIRMATION")
    @Expose
    private Integer confirmation;
    @SerializedName("confirmation_selesai")
    @Expose
    private Integer confirmationSelesai;
    @SerializedName("confirmation_meninggal")
    @Expose
    private Integer confirmationMeninggal;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getKodeProv() {
        return kodeProv;
    }

    public void setKodeProv(String kodeProv) {
        this.kodeProv = kodeProv;
    }

    public String getNamaProv() {
        return namaProv;
    }

    public void setNamaProv(String namaProv) {
        this.namaProv = namaProv;
    }

    public Integer getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Integer confirmation) {
        this.confirmation = confirmation;
    }

    public Integer getConfirmationSelesai() {
        return confirmationSelesai;
    }

    public void setConfirmationSelesai(Integer confirmationSelesai) {
        this.confirmationSelesai = confirmationSelesai;
    }

    public Integer getConfirmationMeninggal() {
        return confirmationMeninggal;
    }

    public void setConfirmationMeninggal(Integer confirmationMeninggal) {
        this.confirmationMeninggal = confirmationMeninggal;
    }

}
