package com.example.lanzarcalculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalcularActivity extends AppCompatActivity {
    EditText en1;
    TextView tv1,tv2;
    Button bt1;
    String nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcular);

        Intent intent = getIntent();
        nombreUsuario = intent.getStringExtra("nombreUsuario");

        en1 = findViewById(R.id.en1);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        bt1 = findViewById(R.id.bt1);
        tv2.setText(nombreUsuario);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplicar(v);
            }
        });

    }
    public void multiplicar(View v) {

        try {
            String valorTexto = en1.getText().toString().trim();
            if (valorTexto.isEmpty()) {
                Toast.makeText(this, "Debes introducir un número", Toast.LENGTH_SHORT).show();
            } else {
                int val = Integer.parseInt(valorTexto);
                val *= 2;
                tv1.setText("Resultado: " + String.valueOf(val));
            }
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_SHORT).show();
        }
    }

}

