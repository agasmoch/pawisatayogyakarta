package com.dev.agasmfauzan.pariwisatayogyakarta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailPariwisata extends AppCompatActivity {
    private ImageView imageView;
    private TextView tv_nama;
    private TextView tv_alamat;
    private TextView tv_desc;
    private Gson gson;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );
        imageView=findViewById( R.id.img_gambarpariwisata );
        tv_nama=findViewById( R.id.tv_namapariwisata );
        tv_alamat=findViewById( R.id.tv_alamatpariwisata );
        tv_desc=findViewById( R.id.tv_deskripsi );
        gson=new Gson();

        String url="http://erporate.com/bootcamp/jsonBootcamp.php";
        RequestQueue queue= Volley.newRequestQueue( this );
        StringRequest stringRequest=new StringRequest( Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        PariwisataResult result=gson.fromJson(response,PariwisataResult.class);
                        Pariwisata pariwisata = result.getPariwisata().get( 0 );
                        tv_nama.setText( pariwisata.getNama_pariwisata() );
                        tv_alamat.setText( pariwisata.getAlamat_pariwisata() );
                        tv_desc.setText( pariwisata.getDetail_parisiwata() );
                        Picasso.get().load( pariwisata.getGambar_pariwisata() ).into( imageView );
                    }
                },
                new Response.ErrorListener(){
            @Override
                    public void onErrorResponse(VolleyError error){

            }
                });
        queue.add(stringRequest);
    }
}
