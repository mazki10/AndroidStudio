package com.example.recuandroidbeinat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class Actividad_Beinat extends AppCompatActivity {
    private EditText tNom, aPe1, aNum;
    private Button botSig, botLim, botFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_beinat);

        // Declaro los EditTexts
        tNom = findViewById(R.id.et1);
        aPe1 = findViewById(R.id.et2);
        aNum = findViewById(R.id.etn1);

        // Declaro los botones
        botSig = findViewById(R.id.bt1);
        botLim = findViewById(R.id.bt2);
        botFin = findViewById(R.id.bt3);

        // Declaro los eventos OnClick
        botSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar(v);
            }
        });

        botLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar(v);
            }
        });

        botFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir(v);
            }
        });

    }
    public void limpiar(View v) {
        // Vacío los EditTexts
        tNom.setText("");
        aPe1.setText("");
        aNum.setText("");
        tNom.requestFocus();
    }
    public void comprobar(View v) {
        String nombre = tNom.getText().toString();
        String ape1 = aPe1.getText().toString();
        String anio = aNum.getText().toString();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(ape1) || TextUtils.isEmpty(anio)) {
            dialogRellenar(v);
        } else {
            comprobarEdad(v);
        }
    }
    public void dialogRellenar(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Vacio")
                .setMessage("ERROR: Debe rellenar todos los campos")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void comprobarEdad(View v) {
        int urtea = Integer.parseInt(aNum.getText().toString());
        int year = Calendar.getInstance().get(Calendar.YEAR);


            int edad = validarEdad(urtea);
            if (edad < 18 ) {
                Toast.makeText(this, "No cumples con los requisitos mínimos de edad", Toast.LENGTH_SHORT).show();
                aNum.setText("");
            } else {
                pasa(v);
            }

    }
    public int validarEdad(int urtea) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - urtea;
    }
    public void pasa(View v) {
        String nombre = tNom.getText().toString();
        String ape1 = aPe1.getText().toString();


        Intent intent = new Intent(this, Actividad_Segunda_Beinat.class);

        intent.putExtra("Nombre", nombre);
        intent.putExtra("Apellido1", ape1);

        startActivity(intent);
    }
    public void salir(View v) {
        finish();
    }
}