package com.example.coronainfo.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponData {
    @SerializedName("content")
    @Expose
    private List<ResponItemData> content = null;

    public List<ResponItemData> getContent() {
        return content;
    }

    public void setContent(List<ResponItemData> content) {
        this.content = content;
    }
}
