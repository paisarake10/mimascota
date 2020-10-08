package com.juancastano.mimascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionbar = findViewById(R.id.miActionbar);
        setSupportActionBar(miActionbar);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarlistaMascotas();
        inicializarAdaptador();

        FloatingActionButton fab = findViewById(R.id.fabi);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sctividad(v);
            }
        });

    }

    private void inicializarAdaptador()
    {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    private void inicializarlistaMascotas()
    {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.dog_icon,"Chandi","5"));
        mascotas.add(new Mascota(R.drawable.dog1_icon,"Pandi","5"));
        mascotas.add(new Mascota(R.drawable.dog2_icon,"Randi","5"));
        mascotas.add(new Mascota(R.drawable.dog3_icon,"Baldi","5"));
        mascotas.add(new Mascota(R.drawable.dog4_icon,"Faldi","5"));
    }

    public void pasarActividad(View view)
    {
        Intent intent = new Intent(this, ListadoMascota.class);
        startActivity(intent);
        finish();
    }

// al no encontrar como al clickear el FAB me subiera al inicio de la vista/pantalla
// hice que me creara de nuevo la misma vista/pantalla , no lo hice dentro del onclick ps
// no deja debe ser por fuera del metodo onCreate
    public void sctividad(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}