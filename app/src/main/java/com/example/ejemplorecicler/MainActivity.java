package com.example.ejemplorecicler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.media.MediaPlayer;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnItemClick
{
    private List<ProductoModelo> productos;

    private ProductoAdapter adapter;

    private int itemElegido;

    private MediaPlayer temaDeFondo;

    private MediaPlayer nombrarPersonaje;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        temaDeFondo = MediaPlayer.create(this, R.raw.tema_principal);

        temaDeFondo.start();

        temaDeFondo.setLooping(true);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.productos = new ArrayList<>();

        this.productos.add(new ProductoModelo("Celular", "15", "65000"));
        this.productos.add(new ProductoModelo("Monitor", "0", "35000"));
        this.productos.add(new ProductoModelo("Procesador i9", "3", "85000"));
        this.productos.add(new ProductoModelo("Módem", "9", "12500"));
        this.productos.add(new ProductoModelo("Pendrive 1T", "80", "8600"));
        this.productos.add(new ProductoModelo("Mouse", "19", "7000"));
        this.productos.add(new ProductoModelo("Laptop", "4", "265000"));
        this.productos.add(new ProductoModelo("Teclado", "6", "5000"));
        this.productos.add(new ProductoModelo("Webcam", "1", "14800"));
        this.productos.add(new ProductoModelo("Placa de video", "0", "195490"));
        this.productos.add(new ProductoModelo("Router", "6", "9000"));

        this.adapter = new ProductoAdapter(productos, this);

        RecyclerView rv = super.findViewById(R.id.rv);

        rv.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rv.setLayoutManager(linearLayoutManager);

        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("ELEGÍ UN LUCHADOR!");
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
        temaDeFondo.start();

        temaDeFondo.setLooping(true);

        if (ProductoActivity.producto != null)
        {
            List<ProductoModelo> productos = this.adapter.getProductos();

            this.productos.set(this.itemElegido, ProductoActivity.producto);

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
        Intent intent = new Intent(this, ProductoActivity.class);

        intent.putExtra("producto", this.productos.get(position));

        this.itemElegido = position;

        startActivity(intent);

        if(this.itemElegido == 1)
        {
            temaDeFondo.pause();

            nombrarPersonaje = MediaPlayer.create(this, R.raw.nombre_liu_kang);

            nombrarPersonaje.start();
        }
    }
}