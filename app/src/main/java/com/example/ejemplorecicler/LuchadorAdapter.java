package com.example.ejemplorecicler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LuchadorAdapter extends RecyclerView.Adapter<LuchadorViewHolder>
{
    private List<LuchadorModelo> luchadores;

    private MyOnItemClick listener;

    public LuchadorAdapter(List<LuchadorModelo> luchadores, MyOnItemClick listener)
    {
        this.luchadores = luchadores;

        this.listener = listener;
    }

    public List<LuchadorModelo> getLuchadores()
    {
        return this.luchadores;
    }

    @NonNull
    @Override
    public LuchadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View viewItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.luchador, parent, false);

        LuchadorViewHolder luchadorViewHolder = new LuchadorViewHolder(viewItemLayout, this.listener);

        return luchadorViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LuchadorViewHolder holder, int position)
    {
        LuchadorModelo luchador = this.luchadores.get(position);

        switch(position)
        {
            case 0:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_liu_kang_round);
                break;

            case 1:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_kung_lao_round);
                break;

            case 2:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_johnny_cage_round);
                break;

            case 3:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_reptile_round);
                break;

            case 4:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_sub_zero_round);
                break;

            case 5:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_shang_tsung_round);
                break;

            case 6:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_kitana_round);
                break;

            case 7:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_jax_round);
                break;

            case 8:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_mileena_round);
                break;

            case 9:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_baraka_round);
                break;

            case 10:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_scorpion_round);
                break;

            case 11:
                holder.iconoPrincipal.setImageResource(R.mipmap.ic_raiden_round);
                break;
        }

        holder.setPosition(position);
    }

    @Override
    public int getItemCount()
    {
        return this.luchadores.size();
    }
}