package com.example.calcularedad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
    }

    public void calcular(View v) {
        LocalDate fecha1 = LocalDate.now();
        String fecha2 = tv1.getText().toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaActualFormateada = fecha1.format(formatter);

        try {
            LocalDate fechaLocalDate = LocalDate.parse(fecha2, formatter);
            Period periodo = Period.between(fechaLocalDate, fecha1);

            int edad = periodo.getYears();

            Toast.makeText(this, String.valueOf(edad), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error a la hora de escribir el formate de fecha.", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Intente con el formato dd/MM/aaaa", Toast.LENGTH_SHORT).show();
        }
    }
}