package com.dev.agasmfauzan.pariwisatayogyakarta.Model;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dev.agasmfauzan.pariwisatayogyakarta.MainActivity;
import com.dev.agasmfauzan.pariwisatayogyakarta.Pariwisata;
import com.dev.agasmfauzan.pariwisatayogyakarta.PariwisataAdapter;
import com.dev.agasmfauzan.pariwisatayogyakarta.PariwisataResult;
import com.dev.agasmfauzan.pariwisatayogyakarta.R;
import com.google.gson.Gson;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class Home extends AppCompatActivity {
   private String[] datanama;
   private String [] datadeskripsi;
   private String[]dataalamat;
   private TypedArray dataPhoto;
   private PariwisataAdapter adapter;
   private ArrayList<Pariwisata>places;
   ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        adapter=new PariwisataAdapter( this );
        listView=findViewById( R.id.rv_wisata );
        prepare();
        addItem();
    }

    private void addItem() {
        places=new ArrayList<>(  );
        for (int i=0; i<datanama.length;i++){
            Pariwisata pariwisatas = new Pariwisata(  );
            pariwisatas.setImage( dataPhoto.getResourceId( i,-1 ) );
            pariwisatas.setNamawisata( datanama[i] );
            pariwisatas.setDeskripsiwisata( datadeskripsi[i] );
            pariwisatas.setAlamatwisata(dataalamat[i]);
            places.add(pariwisatas);

        }
        adapter.setPariwisatas( places );
        listView.setAdapter( adapter );
    }
    private void prepare(){
        datanama=getResources()
                .getStringArray( R.array.nama_pariwisata );
        datadeskripsi=getResources()
                .getStringArray( R.array.detail_pariwisata );
        dataalamat=getResources()
                .getStringArray( R.array.alamat_pariwisata );
        dataPhoto=getResources()
                .obtainTypedArray( R.array.image );
    }
}
