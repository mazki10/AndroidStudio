package com.example.androidbeniat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText tNom, aPe1, aPe2, aNum;
    private Button botSig, botLim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declaro los EditTexts
        tNom = findViewById(R.id.et1);
        aPe1 = findViewById(R.id.et2);
        aPe2 = findViewById(R.id.et3);
        aNum = findViewById(R.id.etn1);

        // Declaro los botones
        botSig = findViewById(R.id.bt1);
        botLim = findViewById(R.id.bt2);

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
    }

    public void limpiar(View v) {
        // Vacío los EditTexts
        tNom.setText("");
        aPe1.setText("");
        aPe2.setText("");
        aNum.setText("");
        tNom.requestFocus();
    }

    public void comprobar(View v) {
        String nombre = tNom.getText().toString();
        String ape1 = aPe1.getText().toString();
        String ape2 = aPe2.getText().toString();
        String anio = aNum.getText().toString();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(ape1) || TextUtils.isEmpty(ape2) || TextUtils.isEmpty(anio)) {
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

    public void dialogAnio(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Formato de año incorrecto")
                .setMessage("ERROR: El año debe estar entre 1900 y el año actual.")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        aNum.setText("");
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void comprobarEdad(View v) {
        int anioInt = Integer.parseInt(aNum.getText().toString());
        int year = Calendar.getInstance().get(Calendar.YEAR);

        if (anioInt < 1900 || anioInt > year) {
            dialogAnio(v);
        } else {
            int edad = calcularEdad(anioInt);
            if (edad < 18 || edad > 65) {
                Toast.makeText(this, "No cumples con los requisitos mínimos de edad", Toast.LENGTH_SHORT).show();
                aNum.setText("");
            } else {
                pasa(v);
            }
        }
    }

    public int calcularEdad(int anio) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - anio;
    }

    public void pasa(View v) {
        String nombre = tNom.getText().toString();
        String ape1 = aPe1.getText().toString();
        String ape2 = aPe2.getText().toString();

        Intent intent = new Intent(this, Actividad_Secundaria_Beniat.class);
        
        intent.putExtra("Nombre", nombre);
        intent.putExtra("Apellido1", ape1);
        intent.putExtra("Apellido2", ape2);

        startActivity(intent);
    }
}
