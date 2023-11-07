package com.example.lanzarcalculo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);

    }

    public void lanzar(View v) {

        String nombreUsuario = et1.getText().toString();

        if (nombreUsuario.equals("")) {
            Toast.makeText(this, "Debes de intruducir el nombre de usuario.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, CalcularActivity.class);
            intent.putExtra("nombreUsuario", nombreUsuario);
            startActivity(intent);
        }
    }

    public void salir(View v){
        finish();
    }
}
