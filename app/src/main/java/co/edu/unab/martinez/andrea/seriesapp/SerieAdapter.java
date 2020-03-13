package co.edu.unab.martinez.andrea.seriesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SerieAdapter extends RecyclerView.Adapter{

    ArrayList<Serie> series;
    onItemClickListener miListener;


    public SerieAdapter(@NonNull ArrayList<Serie> series, onItemClickListener miListener) {
        this.series = series;
        this.miListener = miListener;
    }

    class SerieViewHolder extends RecyclerView.ViewHolder{

        TextView txvNombre;
        ImageView imgPreview;

        public SerieViewHolder(@NonNull View itemView) {
            super(itemView);
            txvNombre = itemView.findViewById(R.id.txv_nombre);
            imgPreview = itemView.findViewById(R.id.imgv_preview);

        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View miVista = LayoutInflater.from(parent.getContext()).inflate(R.layout.series, parent, false);

        return new SerieViewHolder(miVista);


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        SerieViewHolder miHolder =(SerieViewHolder)holder;
        final Serie miSerie = series.get(position);
        miHolder.txvNombre.setText(miSerie.getNombre());
        Picasso.get().load(series.get(position).getUrlpreview()).into(miHolder.imgPreview);

        miHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miListener.onItemClick(miSerie,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }

    interface onItemClickListener{ // Puede tener cualquier nombre
        void onItemClick(Serie miserie, int posicion);

    }
}
