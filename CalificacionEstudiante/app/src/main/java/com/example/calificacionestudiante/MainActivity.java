package com.example.calificacionestudiante;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private EditText en1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        en1 = findViewById(R.id.en1);
    }

    public void mostrar(View v) {
        String valorTexto = en1.getText().toString().trim();  // Obtener el valor del EditText y eliminar espacios en blanco

        if (valorTexto.isEmpty() || tv1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Debes introducir valores en los campos correspondidos", Toast.LENGTH_SHORT).show();
        } else {
            try {
                Double val = Double.parseDouble(valorTexto);

                String calificacion;
                String alumno = tv1.getText().toString();

                if (val < 0 || val > 20) {
                    Toast.makeText(this, "Debes introducir un número entre 0 y 20", Toast.LENGTH_SHORT).show();
                    en1.setText("");
                } else {
                    if (val >= 0 && val <= 10.5) {
                        calificacion = "Malo";
                    } else if (val > 10.5 && val <= 14) {
                        calificacion = "Regular";
                    } else if (val > 14 && val <= 18) {
                        calificacion = "Bueno";
                    } else {
                        calificacion = "Excelente";
                    }

                    String resultado = "La calificación del alumno " + alumno + " es " + calificacion;

                    Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                // Manejar el error cuando el valor ingresado no es un número válido
                Toast.makeText(this, "Error: Ingresa un número válido en el campo de valor", Toast.LENGTH_SHORT).show();
                en1.setText("");
            }
        }
    }
    
    public void limpiar(View v) {

        tv1.setText("");
        en1.setText("");

    }
}