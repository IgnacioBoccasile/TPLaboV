package com.example.ejemplorecicler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.media.MediaPlayer;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick
{
    private List<LuchadorModelo> luchadores;

    private LuchadorAdapter adapter;

    private int itemElegido;

    private MediaPlayer temaDeFondo;

    private MediaPlayer elegirPersonaje;

    private MediaPlayer nombrarPersonaje;

    private MediaPlayer temaDePersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        temaDeFondo = MediaPlayer.create(this, R.raw.tema_principal);

        temaDeFondo.start();

        temaDeFondo.setLooping(true);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.luchadores = new ArrayList<>();

        this.luchadores.add(new LuchadorModelo("LIU KANG", R.drawable.img_liu_kang, getString(R.string.bio_liu_kang), getString(R.string.fatality1_liu_kang), R.drawable.liu_kang_fatality_1, getString(R.string.fatality2_liu_kang), R.drawable.liu_kang_fatality_2));
        this.luchadores.add(new LuchadorModelo("KUNG LAO", R.drawable.img_kung_lao, getString(R.string.bio_kung_lao), getString(R.string.fatality1_kung_lao), R.drawable.kung_lao_fatality_1, getString(R.string.fatality2_kung_lao), R.drawable.kung_lao_fatality_2));
        this.luchadores.add(new LuchadorModelo("JOHNNY CAGE", R.drawable.img_johnny_cage, getString(R.string.bio_johnny_cage), getString(R.string.fatality1_johnny_cage), R.drawable.johnny_cage_fatality_1, getString(R.string.fatality2_johnny_cage), R.drawable.johnny_cage_fatality_2));
        this.luchadores.add(new LuchadorModelo("REPTILE", R.drawable.img_reptile, getString(R.string.bio_reptile), getString(R.string.fatality1_reptile), R.drawable.reptile_fatality_1, getString(R.string.fatality2_reptile), R.drawable.reptile_fatality_2));
        this.luchadores.add(new LuchadorModelo("SUB-ZERO", R.drawable.img_sub_zero, getString(R.string.bio_sub_zero), getString(R.string.fatality1_sub_zero), R.drawable.sub_zero_fatality_1, getString(R.string.fatality2_sub_zero), R.drawable.sub_zero_fatality_2));
        this.luchadores.add(new LuchadorModelo("SHANG TSUNG", R.drawable.img_shang_tsung, getString(R.string.bio_shang_tsung), getString(R.string.fatality1_shang_tsung), R.drawable.shang_tsung_fatality_1, getString(R.string.fatality2_shang_tsung), R.drawable.shang_tsung_fatality_2));
        this.luchadores.add(new LuchadorModelo("KITANA", R.drawable.img_kitana, getString(R.string.bio_kitana), getString(R.string.fatality1_kitana), R.drawable.kitana_fatality_1, getString(R.string.fatality2_kitana), R.drawable.kitana_fatality_2));
        this.luchadores.add(new LuchadorModelo("JAX", R.drawable.img_jax, getString(R.string.bio_jax), getString(R.string.fatality1_jax), R.drawable.jax_fatality_1, getString(R.string.fatality2_jax), R.drawable.jax_fatality_2));
        this.luchadores.add(new LuchadorModelo("MILEENA", R.drawable.img_mileena, getString(R.string.bio_mileena), getString(R.string.fatality1_mileena), R.drawable.mileena_fatality_1, getString(R.string.fatality2_mileena), R.drawable.mileena_fatality_2));
        this.luchadores.add(new LuchadorModelo("BARAKA", R.drawable.img_baraka, getString(R.string.bio_baraka), getString(R.string.fatality1_baraka), R.drawable.baraka_fatality_1, getString(R.string.fatality2_baraka), R.drawable.baraka_fatality_2));
        this.luchadores.add(new LuchadorModelo("SCORPION", R.drawable.img_scorpion, getString(R.string.bio_scorpion), getString(R.string.fatality1_scorpion), R.drawable.scorpion_fatality_1, getString(R.string.fatality2_scorpion), R.drawable.scorpion_fatality_2));
        this.luchadores.add(new LuchadorModelo("RAIDEN", R.drawable.img_raiden, getString(R.string.bio_raiden), getString(R.string.fatality1_raiden), R.drawable.raiden_fatality_1, getString(R.string.fatality2_raiden), R.drawable.raiden_fatality_2));

        this.adapter = new LuchadorAdapter(luchadores, this);

        RecyclerView rv = super.findViewById(R.id.rv);

        rv.setAdapter(adapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);

        rv.setLayoutManager(gridLayoutManager);
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

        overridePendingTransition(R.anim.translate_left_side, R.anim.translate_right_side);

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