package com.juancastano.mimascota;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListadoMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_listado);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicializarAdaptador();

        Toolbar miActionBar = findViewById(R.id.miActionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        miActionBar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListadoMascota.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ListadoMascota.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    private void inicializarAdaptador()
    {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    private void inicializarlistaMascotas()
    {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.dog1_icon,"Pandi","2"));
        mascotas.add(new Mascota(R.drawable.dog3_icon,"Baldi","4"));
        mascotas.add(new Mascota(R.drawable.dog4_icon,"Faldi","5"));
        mascotas.add(new Mascota(R.drawable.dog_icon,"Chandi","3"));
        mascotas.add(new Mascota(R.drawable.dog2_icon,"Randi","5"));
    }

}