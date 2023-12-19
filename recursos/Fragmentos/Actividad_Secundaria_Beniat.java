package com.example.androidbeniat;

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

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Actividad_Secundaria_Beniat extends AppCompatActivity {
    private EditText ing;
    private Button botRes, botLim, botSal;
    private RadioButton snHi, unHi, maHi;

    private RadioGroup gru;

    String nombre, ape1, ape2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_secundaria_beniat);

        ing = findViewById(R.id.etn2);

        botRes = findViewById(R.id.bt3);
        botLim = findViewById(R.id.bt4);
        botSal = findViewById(R.id.bt5);

        snHi = findViewById(R.id.rb1);
        unHi = findViewById(R.id.rb2);
        maHi = findViewById(R.id.rb2);

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
        ape2 = intent.getStringExtra("Apellido2");

    }

    public void limpiar(View v) {

        ing.setText("");
        gru.clearCheck();
    }

    public boolean evaluarSolicitud(int numerosHijos, Double ingresoAnual) {

        Boolean aceptado = false;

        if (ingresoAnual <= 9000) {
            aceptado = true;
        } else if (ingresoAnual >= 9000 && ingresoAnual <= 20000 && numerosHijos >= 1) {
            aceptado = true;
        } else if (ingresoAnual > 20000 && ingresoAnual <= 30000 && numerosHijos > 1) {
            aceptado = true;
        }

        return aceptado;
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

    public void mostrarSolicitud(View v) {
        Double ingresos = Double.parseDouble(ing.getText().toString());
        int hijos = 0;

        if (unHi.isChecked()) {
            hijos = 0;
        } else {
            if (unHi.isChecked()) {
                hijos = 1;
            } else {
                if (maHi.isChecked()) {
                    hijos = 3;
                }
            }
        }

        String resultado;

        Boolean acept = evaluarSolicitud(hijos, ingresos);

        if (acept) {
            resultado = "ACEPTADO";
        } else {
            resultado = "DENEGADO";
        }

        String estructuraSolicitud = "La solicitud de " + nombre + " " + ape1 + " " + ape2 + " a sido " + resultado;

        Toast.makeText(this, estructuraSolicitud, Toast.LENGTH_SHORT).show();
    }

    public void salir(View v) {
        finish();
    }
}