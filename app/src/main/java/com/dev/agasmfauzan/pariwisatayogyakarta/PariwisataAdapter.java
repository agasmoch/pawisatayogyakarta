package com.dev.agasmfauzan.pariwisatayogyakarta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PariwisataAdapter extends RecyclerView.Adapter<PariwisataAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<Pariwisata>pariwisatas;
    private OnClickListener listener;


    public void setListener(OnClickListener listener) {
        this.listener=listener;
    }

    public PariwisataAdapter(Context mContext) {
        this.mContext = mContext;
        this.pariwisatas = new ArrayList<>();
    }

    public void setPariwisatas(ArrayList<Pariwisata>pariwisatas){
        this.pariwisatas=pariwisatas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PariwisataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from( mContext );
        View view=inflater.inflate( R.layout.list_tempat_wisata,parent,false );
        ViewHolder holder = new ViewHolder( view );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PariwisataAdapter.ViewHolder holder, int position) {
        Pariwisata currentPariwisata=pariwisatas.get( position );
        holder.tvnama.setText(currentPariwisata.getNama_pariwisata());
        Picasso.get().load(currentPariwisata.getGambar_pariwisata()).fit().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return (pariwisatas == null) ? 0 : pariwisatas.size();


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvnama;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            imageView=itemView.findViewById( R.id.imageView );
            tvnama=itemView.findViewById( R.id.tv_namapariwisata);
            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        listener.click( getAdapterPosition() );
                    }
                }
            } );
        }
    }
}
