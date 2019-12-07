package com.dev.agasmfauzan.pariwisatayogyakarta.Model;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dev.agasmfauzan.pariwisatayogyakarta.DetailPariwisata;
import com.dev.agasmfauzan.pariwisatayogyakarta.MainActivity;
import com.dev.agasmfauzan.pariwisatayogyakarta.OnClickListener;
import com.dev.agasmfauzan.pariwisatayogyakarta.Pariwisata;
import com.dev.agasmfauzan.pariwisatayogyakarta.PariwisataAdapter;
import com.dev.agasmfauzan.pariwisatayogyakarta.PariwisataResult;
import com.dev.agasmfauzan.pariwisatayogyakarta.R;
import com.google.gson.Gson;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private RecyclerView rvPariwisata;
    private PariwisataAdapter adapter;
    private ArrayList<Pariwisata>pariwisatas;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        rvPariwisata=findViewById( R.id.rv_wisata );
        adapter=new PariwisataAdapter( this );
        pariwisatas=new ArrayList<>(  );
        gson=new Gson();

        ambildata();

        LinearLayoutManager lm = new LinearLayoutManager( this,LinearLayoutManager.HORIZONTAL,false );
        DividerItemDecoration divider= new DividerItemDecoration( this,lm.getOrientation() );
        GridLayoutManager gridLayoutManager=new GridLayoutManager( this,2 ,RecyclerView.VERTICAL,false);
        StaggeredGridLayoutManager lm3= new StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL );
        rvPariwisata.setLayoutManager( gridLayoutManager );
        rvPariwisata.setAdapter( adapter );
        rvPariwisata.addItemDecoration( divider );

        adapter.setListener( new OnClickListener() {
            @Override
            public void click(int position) {
                Intent intent=new Intent( Home.this, DetailPariwisata.class );
                startActivity( intent );
            }
        } );
    }


    private void ambildata() {
        RequestQueue queue = Volley.newRequestQueue( this );
        StringRequest stringRequest= new StringRequest( Request.Method.GET, "http://erporate.com/bootcamp/jsonBootcamp.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        PariwisataResult result = gson.fromJson( response, PariwisataResult.class );
                        pariwisatas = result.getPariwisata();
                        adapter.setPariwisatas( pariwisatas );
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } );
        queue.add( stringRequest );
    }
}
