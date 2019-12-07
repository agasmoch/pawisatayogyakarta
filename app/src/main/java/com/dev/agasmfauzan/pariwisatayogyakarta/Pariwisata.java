package com.dev.agasmfauzan.pariwisatayogyakarta;

public class Pariwisata {
    private String nama_pariwisata;
    private String alamat_pariwisata;
    private String detail_parisiwata;
    private String gambar_pariwisata;

    public Pariwisata(String nama_pariwisata, String alamat_pariwisata, String detail_parisiwata, String gambar_pariwisata) {
        this.nama_pariwisata = nama_pariwisata;
        this.alamat_pariwisata = alamat_pariwisata;
        this.detail_parisiwata = detail_parisiwata;
        this.gambar_pariwisata = gambar_pariwisata;
    }

    public String getNama_pariwisata() {
        return nama_pariwisata;
    }

    public String getAlamat_pariwisata() {
        return alamat_pariwisata;
    }

    public String getDetail_parisiwata() {
        return detail_parisiwata;
    }

    public String getGambar_pariwisata() {
        return gambar_pariwisata;
    }
}
