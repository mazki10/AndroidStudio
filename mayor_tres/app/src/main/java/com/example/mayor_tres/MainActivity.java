package com.example.mayor_tres;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2, et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.en1);
        et2 = (EditText) findViewById(R.id.en2);
        et3 = (EditText) findViewById(R.id.en3);

    }

    public void calcular(View v) {
        try {
            int val1 = Integer.parseInt(et1.getText().toString());
            int val2 = Integer.parseInt(et2.getText().toString());
            int val3 = Integer.parseInt(et3.getText().toString());

            int[] lista = new int[]{val1, val2, val3};

            int val4 = lista[0];

            for (int i = 0; i < lista.length; i++) {
                if (val4 < lista[i]) {
                    val4 = lista[i];
                }
            }

            String resultado = "El valor más alto introducido es: " + val4;

            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error: Ingresa valores numéricos en todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}