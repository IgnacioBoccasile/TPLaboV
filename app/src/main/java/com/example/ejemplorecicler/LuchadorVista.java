package com.example.ejemplorecicler;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import pl.droidsonroids.gif.GifImageView;

public class LuchadorVista
{
    private Activity activity;

    private LuchadorModelo modelo;

    private TextView txtNombre;

    private ImageView imagenLuchador;

    private GifImageView stanceLuchador;

    public LuchadorVista(Activity activity, LuchadorModelo modelo, LuchadorControlador controlador)
    {
        this.activity = activity;

        this.modelo = modelo;

        this.txtNombre = this.activity.findViewById(R.id.txtNombre);

        this.imagenLuchador = this.activity.findViewById(R.id.imagenLuchador);

        this.imagenLuchador.setImageResource(modelo.getImagenPersonaje());

        this.stanceLuchador = this.activity.findViewById(R.id.stanceLuchador);

        ActionBar actionBar = ((AppCompatActivity) this.activity).getSupportActionBar();

        actionBar.setTitle(modelo.getNombre());

        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}