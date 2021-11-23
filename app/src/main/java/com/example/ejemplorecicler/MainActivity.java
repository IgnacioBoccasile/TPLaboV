package com.example.ejemplorecicler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.text.Html;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity implements MyOnItemClick
{
    private List<LuchadorModelo> luchadores;

    private LuchadorAdapter adapter;

    private int itemElegido;

    private MediaPlayer temaDeFondo;

    private MediaPlayer elegirPersonaje;

    private MediaPlayer nombrarPersonaje;

    private MediaPlayer temaDePersonaje;

    private GifImageView stancePersonaje;

    private String titulo = "hola";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        temaDeFondo = MediaPlayer.create(this, R.raw.tema_principal);

        temaDeFondo.start();

        temaDeFondo.setLooping(true);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.luchadores = new ArrayList<>();

        this.luchadores.add(new LuchadorModelo("Liu Kang", R.drawable.img_liu_kang));
        this.luchadores.add(new LuchadorModelo("Kung Lao", R.drawable.img_kung_lao));
        this.luchadores.add(new LuchadorModelo("Johnny Cage", R.drawable.img_johnny_cage));
        this.luchadores.add(new LuchadorModelo("Reptile", R.drawable.img_reptile));
        this.luchadores.add(new LuchadorModelo("Sub Zero", R.drawable.img_sub_zero));
        this.luchadores.add(new LuchadorModelo("Shang Tsung", R.drawable.img_shang_tsung));
        this.luchadores.add(new LuchadorModelo("Kitana", R.drawable.img_kitana));
        this.luchadores.add(new LuchadorModelo("Jax", R.drawable.img_jax));
        this.luchadores.add(new LuchadorModelo("Mileena", R.drawable.img_mileena));
        this.luchadores.add(new LuchadorModelo("Baraka", R.drawable.img_baraka));
        this.luchadores.add(new LuchadorModelo("Scorpion", R.drawable.img_scorpion));
        this.luchadores.add(new LuchadorModelo("Raiden", R.drawable.img_raiden));

        this.adapter = new LuchadorAdapter(luchadores, this);

        RecyclerView rv = super.findViewById(R.id.rv);

        rv.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);

        rv.setLayoutManager(gridLayoutManager);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle(Html.fromHtml("<font color=\"#FFFF00\">" + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp MORTAL KOMBAT WIKI" + "</font>"));

        Drawable d= getResources().getDrawable(R.drawable.fondo_menu);

        actionBar.setBackgroundDrawable(d);
    }

    @Override
    protected void onStop()
    {
        temaDeFondo.pause();

        temaDeFondo.seekTo(0);

        super.onStop();
    }

    @Override
    protected void onRestart()
    {
        elegirPersonaje.pause();

        nombrarPersonaje.pause();

        temaDePersonaje.pause();

        temaDeFondo.start();

        temaDeFondo.setLooping(true);

        if (LuchadorActivity.luchador != null)
        {
            List<LuchadorModelo> luchadores = this.adapter.getLuchadores();

            this.luchadores.set(this.itemElegido, LuchadorActivity.luchador);

            this.adapter.notifyItemChanged(this.itemElegido);
        }

        super.onRestart();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            super.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position)
    {
        Intent intent = new Intent(this,LuchadorActivity.class);

        intent.putExtra("luchador", this.luchadores.get(position));

        this.itemElegido = position;

        startActivity(intent);

        switch(this.itemElegido)
        {
            case 0:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_liu_kang);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_liu_kang);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 1:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_kung_lao);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_kung_lao);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 2:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_johnny_cage);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_johnny_cage);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 3:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_reptile);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_reptile);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 4:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_sub_zero);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_sub_zero);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 5:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_shang_tsung);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_shang_tsung);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 6:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_kitana);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_kitana);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 7:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_jax);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_jax);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 8:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_mileena);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_mileena);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 9:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_baraka);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_baraka);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 10:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_scorpion);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_scorpion);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;

            case 11:
                temaDeFondo.pause();
                elegirPersonaje = MediaPlayer.create(this, R.raw.efecto_elegir);
                elegirPersonaje.start();
                nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_raiden);
                temaDePersonaje = MediaPlayer.create(this,R.raw.tema_raiden);
                elegirPersonaje.setNextMediaPlayer(nombrarPersonaje);
                nombrarPersonaje.setNextMediaPlayer(temaDePersonaje);
                temaDePersonaje.setLooping(true);
                break;
        }
    }
}