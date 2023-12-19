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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Actividad_Segunda_Beinat extends AppCompatActivity {
    private EditText ing;
    private Button botRes, botLim, botSal;
    private RadioButton no, si;

    private RadioGroup gru;

    String nombre, ape1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_segunda_beinat);

        ing = findViewById(R.id.etn2);

        botRes = findViewById(R.id.bt3);
        botLim = findViewById(R.id.bt4);
        botSal = findViewById(R.id.bt5);

        no = findViewById(R.id.rb1);
        si = findViewById(R.id.rb2);


        gru = findViewById(R.id.radioGroup);

        botLim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar(v);
            }
        });

        botRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobar(v);
            }
        });

        botSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir(v);
            }
        });

        Intent intent = getIntent();
        nombre = intent.getStringExtra("Nombre");
        ape1 = intent.getStringExtra("Apellido1");
    }
    public void limpiar(View v) {

        ing.setText("");
        gru.clearCheck();
    }

    public void comprobar(View v) {

        String ingresos = ing.getText().toString();
        int selectedRadioButtonId = gru.getCheckedRadioButtonId();

        if (TextUtils.isEmpty(ingresos) || selectedRadioButtonId == -1) {
            dialogRellenar(v);
        } else {
            mostrarSolicitud(v);
        }

    }
    public void dialogRellenar(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Vacio")
                .setMessage("ERROR: Debe rellenar todos los campos")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void salir(View v) {
        finish();
    }
    public void mostrarSolicitud(View v) {
        Double ingresos = Double.parseDouble(ing.getText().toString());
        boolean familia = false;

        if (si.isChecked()) {
            familia = true;
        } else {
            if (no.isChecked()){
                familia = false;
            }
        }

        String resultado;

        Boolean acept = evaluarSolicitud(familia, ingresos);

        if (acept) {
            resultado = "ACEPTADO";
        } else {
            resultado = "DENEGADO";
        }

        String estructuraSolicitud = "La solicitud de " + nombre + " " + ape1 + " a sido " + resultado;

        Toast.makeText(this, estructuraSolicitud, Toast.LENGTH_SHORT).show();
    }
    public boolean evaluarSolicitud(boolean familia, Double ingresoAnual) {

        Boolean aceptado = false;

        if (familia==true&&ingresoAnual<20000){
            aceptado = true;
        }else {
            if (familia==false&&ingresoAnual<10000){
                aceptado= true;
            }
        }

        return aceptado;
    }
}