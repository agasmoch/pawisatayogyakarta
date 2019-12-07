package com.dev.agasmfauzan.pariwisatayogyakarta;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PariwisataResult {
    @SerializedName(value = "pariwisata",alternate = {"pariwisatas"})
    private ArrayList<Pariwisata>pariwisata;

    public ArrayList<Pariwisata> getPariwisata() {
        return pariwisata;
    }

    public PariwisataResult(ArrayList<Pariwisata>pariwisata) {
        this.pariwisata=pariwisata;
    }
}
