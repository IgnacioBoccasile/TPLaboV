package com.example.ejemplorecicler;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity
{
    private final int duration = 5500;

    private MediaPlayer sonidoCargaPrimeraVez;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                Intent intent = new Intent(Splash.this, Start.class);

                startActivity(intent);

                finish();
            };
        }, duration);

        sonidoCargaPrimeraVez = MediaPlayer.create(this, R.raw.cargando);

        sonidoCargaPrimeraVez.start();
    }
}