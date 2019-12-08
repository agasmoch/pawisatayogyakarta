package com.dev.agasmfauzan.pariwisatayogyakarta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PariwisataAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<Pariwisata>places;
    public void setPariwisatas(ArrayList<Pariwisata>pariwisatas){
        this.places=pariwisatas;
    }
    public PariwisataAdapter (Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int i) {
        return places.get( i );
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null)
        {
            view=LayoutInflater.from( context )
                    .inflate(R.layout.activity_detail,viewGroup,false);
        }
        ViewHolder viewHolder= new ViewHolder( view );
        Pariwisata pariwisata=(Pariwisata)getItem( i );
        viewHolder.bind(pariwisata);
        return view;
    }
    private class ViewHolder{
        private TextView txtname;
        private TextView txtdesc;
        private TextView txtaddress;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtname=view.findViewById( R.id.tv_namapariwisata );
            txtaddress=view.findViewById(R.id.tv_alamatpariwisata  );
            txtdesc=view.findViewById( R.id.tv_deskripsi );
            imgPhoto=view.findViewById( R.id.img_gambarpariwisata );
        }
        void bind(Pariwisata pariwisata){
            imgPhoto.setImageResource( pariwisata.getImage() );
            txtaddress.setText( pariwisata.getAlamatwisata() );
            txtname.setText( pariwisata.getNamawisata() );
            txtdesc.setText( pariwisata.getDeskripsiwisata() );
        }
    }


}