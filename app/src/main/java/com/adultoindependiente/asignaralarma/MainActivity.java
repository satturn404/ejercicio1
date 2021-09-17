package com.adultoindependiente.asignaralarma;

import static android.provider.AlarmClock.ACTION_SET_ALARM;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


  Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton=findViewById(R.id.alarma);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CrearAlarma("TIEMPO AGOTADO",5);
            }
        });

        Toolbar toolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
    public void CrearAlarma(String mensaje,int SEGUNDOS){
        Intent intent= new Intent(AlarmClock.ACTION_SET_TIMER)
        .putExtra(AlarmClock.EXTRA_MESSAGE,mensaje)
        .putExtra(AlarmClock.EXTRA_LENGTH, SEGUNDOS)
        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}