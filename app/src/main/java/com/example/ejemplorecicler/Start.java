package com.example.ejemplorecicler;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class Start extends AppCompatActivity
{
    TextView gitHub;

    GifImageView start;

    MediaPlayer risa;

    MediaPlayer temaPres;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.press_start);

        risa = MediaPlayer.create(this, R.raw.risa);

        temaPres = MediaPlayer.create(this, R.raw.tema_pres);

        risa.start();

        temaPres.start();

        temaPres.setLooping(true);

        gitHub = findViewById(R.id.gitHub);

        gitHub.setMovementMethod(LinkMovementMethod.getInstance());

        start = findViewById((R.id.start));

        start.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                risa.pause();

                temaPres.pause();

                Intent intent = new Intent(Start.this, MainActivity.class);

                startActivity(intent);

                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            }
        });
    }

    @Override
    protected void onResume()
    {
        risa.start();

        temaPres.start();

        super.onResume();
    }

    @Override
    protected void onStop()
    {
        risa.pause();

        risa.seekTo(0);

        temaPres.pause();

        temaPres.seekTo(0);

        super.onStop();
    }
}