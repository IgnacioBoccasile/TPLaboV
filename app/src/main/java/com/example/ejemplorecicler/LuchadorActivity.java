package com.example.ejemplorecicler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.MenuItem;

public class LuchadorActivity extends AppCompatActivity
{
    public static LuchadorModelo luchador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_luchador);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        actionBar.setCustomView(R.layout.menu_luchador);

        actionBar.setDisplayHomeAsUpEnabled(true);

        Drawable d = getResources().getDrawable(R.drawable.fondo_menu);

        actionBar.setBackgroundDrawable(d);

        Bundle extras = super.getIntent().getExtras();

        LuchadorModelo modelo = (LuchadorModelo) extras.getSerializable("luchador");

        LuchadorControlador controlador = new LuchadorControlador(modelo, this);

        LuchadorVista vista = new LuchadorVista(this, modelo, controlador);

        controlador.setVista(vista);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            LuchadorActivity.luchador = null;

            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}