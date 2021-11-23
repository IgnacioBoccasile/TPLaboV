package com.example.ejemplorecicler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class LuchadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    private MyOnItemClick listener;

    private int position;

    ImageView iconoPrincipal;

    public LuchadorViewHolder(View viewItemLayout, MyOnItemClick listener)
    {
        super(viewItemLayout);

        this.listener = listener;

        this.iconoPrincipal = viewItemLayout.findViewById(R.id.imgLuchador);

        this.iconoPrincipal.setOnClickListener(this);
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    @Override
    public void onClick(View view)
    {
        listener.onItemClick(position);
    }
}