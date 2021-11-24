package com.example.ejemplorecicler;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class LuchadorVista
{
    private Activity activity;

    private LuchadorModelo modelo;

    private TextView txtTitle;

    private ImageView imagenLuchador;

    private TextView txtBio;

    private TextView txtFatality1;

    private GifImageView imagenFatality1;

    private TextView txtFatality2;

    private GifImageView imagenFatality2;

    public LuchadorVista(Activity activity, LuchadorModelo modelo, LuchadorControlador controlador)
    {
        this.activity = activity;

        this.modelo = modelo;

        this.txtTitle = this.activity.findViewById(R.id.txtTitle);

        this.txtTitle.setText(modelo.getNombre());

        this.imagenLuchador = this.activity.findViewById(R.id.imagenLuchador);

        this.imagenLuchador.setImageResource(modelo.getImagenPersonaje());

        this.txtBio = this.activity.findViewById(R.id.txtBio);

        this.txtBio.setText(modelo.getBio());

        this.txtFatality1 = this.activity.findViewById(R.id.txtFatality1);

        this.txtFatality1.setText(modelo.getTxtFatality1());

        this.imagenFatality1 = this.activity.findViewById(R.id.imgFatality1);

        this.imagenFatality1.setImageResource(modelo.getImagenFatality1());

        this.txtFatality2 = this.activity.findViewById(R.id.txtFatality2);

        this.txtFatality2.setText(modelo.getTxtFatality2());

        this.imagenFatality2 = this.activity.findViewById(R.id.imgFatality2);

        this.imagenFatality2.setImageResource(modelo.getImagenFatality2());
    }
}