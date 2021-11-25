package com.example.ejemplorecicler;


import java.io.Serializable;

public class LuchadorModelo implements Serializable
{
    private String nombre;

    private Integer imagenPersonaje;

    private String bio;

    private String txtFatality1;

    private Integer imagenFatality1;

    private String txtFatality2;

    private Integer imagenFatality2;

    public LuchadorModelo() { }

    public LuchadorModelo(String nombre, Integer imagenPersonaje, String bio, String txtFatality1, Integer imagenFatality1, String txtFatality2, Integer imagenFatality2)
    {
        this.nombre = nombre;

        this.imagenPersonaje = imagenPersonaje;

        this.bio = bio;

        this.txtFatality1 = txtFatality1;

        this.imagenFatality1 = imagenFatality1;

        this.txtFatality2 = txtFatality2;

        this.imagenFatality2 = imagenFatality2;
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

    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    public String getTxtFatality1()
    {
        return txtFatality1;
    }

    public void setTxtFatality1(String txtFatality1)
    {
        this.txtFatality1 = txtFatality1;
    }

    public Integer getImagenFatality1()
    {
        return imagenFatality1;
    }

    public void setImagenFatality1(Integer imagenFatality1)
    {
        this.imagenFatality1 = imagenFatality1;
    }

    public String getTxtFatality2()
    {
        return txtFatality2;
    }

    public void setTxtFatality2(String txtFatality2)
    {
        this.txtFatality2 = txtFatality2;
    }

    public Integer getImagenFatality2()
    {
        return imagenFatality2;
    }

    public void setImagenFatality2(Integer imagenFatality2)
    {
        this.imagenFatality2 = imagenFatality2;
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

            if (this.nombre.equals(u.nombre) && this.imagenPersonaje.equals(u.imagenPersonaje) && this.bio.equals(u.bio) && this.txtFatality1.equals(u.txtFatality1) && this.imagenFatality1.equals(u.imagenFatality1) && this.txtFatality2.equals(u.txtFatality2) && this.imagenFatality2.equals(u.imagenFatality2))
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

        retorno += this.bio.hashCode();

        retorno += this.txtFatality1.hashCode();

        retorno += this.imagenFatality1.hashCode();

        retorno += this.txtFatality2.hashCode();

        retorno += this.imagenFatality2.hashCode();

        return retorno;
    }
}