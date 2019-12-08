package com.dev.agasmfauzan.pariwisatayogyakarta;

public class Pariwisata {
   int image;
   String namawisata;
   String deskripsiwisata;
   String alamatwisata;
   public Pariwisata(){
   }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNamawisata() {
        return namawisata;
    }

    public void setNamawisata(String namawisata) {
        this.namawisata = namawisata;
    }

    public String getDeskripsiwisata() {
        return deskripsiwisata;
    }

    public void setDeskripsiwisata(String deskripsiwisata) {
        this.deskripsiwisata = deskripsiwisata;
    }

    public String getAlamatwisata() {
        return alamatwisata;
    }

    public void setAlamatwisata(String alamatwisata) {
        this.alamatwisata = alamatwisata;
    }

    public Pariwisata(int image, String namawisata, String deskripsiwisata, String alamatwisata) {
        this.image = image;
        this.namawisata = namawisata;
        this.deskripsiwisata = deskripsiwisata;
        this.alamatwisata = alamatwisata;
    }
}
