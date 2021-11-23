package com.example.ejemplorecicler;

import java.io.Serializable;

public class LuchadorModelo implements Serializable
{
    private String nombre;

    private Integer imagenPersonaje;

    public LuchadorModelo() { }

    public LuchadorModelo(String nombre, int imagenPersonaje)
    {
        this.nombre = nombre;

        this.imagenPersonaje = imagenPersonaje;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Integer getImagenPersonaje()
    {
        return imagenPersonaje;
    }

    public void setImagenPersonaje(Integer imagenPersonaje)
    {
        this.imagenPersonaje = imagenPersonaje;
    }

    @Override
    public boolean equals(Object o)
    {
        if(o == null)
        {
            return false;
        }
        else if (o.getClass().equals(this.getClass()))
        {
            LuchadorModelo u = (LuchadorModelo) o;

            if (this.nombre.equals(u.nombre) && this.imagenPersonaje.equals(u.imagenPersonaje))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    @Override
    public int hashCode()
    {
        final int primo = 23;

        int retorno = 0;

        retorno = primo * this.nombre.hashCode();

        retorno += this.imagenPersonaje.hashCode();

        return retorno;
    }

    @Override
    public String toString()
    {
        return this.nombre;
    }
}