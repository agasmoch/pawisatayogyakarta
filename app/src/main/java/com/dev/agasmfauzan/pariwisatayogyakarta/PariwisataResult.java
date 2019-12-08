package com.dev.agasmfauzan.pariwisatayogyakarta;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PariwisataResult {
    @SerializedName(value = "data",alternate = {"datas"})
    private ArrayList<Pariwisata>data;

    public ArrayList<Pariwisata> getPariwisata() {
        return data;
    }

    public PariwisataResult(ArrayList<Pariwisata>data) {
        this.data=data;
    }
}
