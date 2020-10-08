package com.juancastano.mimascota;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaAdapter.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_mascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaAdapter.MascotaViewHolder holder, int position)
    {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvNum.setText(mascota.getNum());
    }

    @Override
    public int getItemCount()
    {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvNum;

        public MascotaViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgFoto =itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvNum = itemView.findViewById(R.id.tvNum);
        }
    }
}
