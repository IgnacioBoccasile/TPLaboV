package com.example.ejemplorecicler;

import android.app.Activity;

public class LuchadorControlador
{
    private LuchadorModelo modelo;

    private LuchadorVista vista;

    private Activity activity;

    public LuchadorControlador(LuchadorModelo modelo, Activity activity)
    {
        this.modelo = modelo;

        this.activity = activity;
    }

    public void setVista(LuchadorVista vista)
    {
        this.vista = vista;
    }
}