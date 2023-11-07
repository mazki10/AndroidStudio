package com.example.myapplication;

import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private RadioButton r1, r2, r3, r4;

    private Button botonCal, botonLimp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditTexts
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        //TextsView
        tv1 = (TextView) findViewById(R.id.TV1);

        //RadioButtons
        r1 = (RadioButton) findViewById(R.id.rb1);
        r2 = (RadioButton) findViewById(R.id.rb2);
        r3 = (RadioButton) findViewById(R.id.rb3);
        r4 = (RadioButton) findViewById(R.id.rb4);

        r1.setChecked(true);


        //Botones
        botonCal = (Button) findViewById(R.id.bt1);
        botonLimp = (Button) findViewById(R.id.bt2);

        botonCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                comprobar(v);
            }
        });

        botonLimp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar(v);
            }
        });
    }

    public void  limpiar(View v)
    {
        tv1.setText("EL RESULTADO ES: ");
        et1.setText("");
        et2.setText("");

        et1.requestFocus();

    }

    public void comprobar(View v){
        String val1 = et1.getText().toString();
        String val2 = et2.getText().toString();
        String mensaje = "Debe de introducir los valores correspondientes";

        if (val1.isEmpty()||val2.isEmpty()){
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }else {
            calcular(v);
        }
    }

    public void calcular(View v)
    {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        int v1 = Integer.parseInt(s1);
        int v2 = Integer.parseInt(s2);

        if (r1.isChecked()){
            int resultado = v1 + v2;
            tv1.setText("EL RESULTADO ES: "+resultado);
        }else {
            if(r2.isChecked()){
                int resultado = v1 - v2;
                tv1.setText("EL RESULTADO ES: "+resultado);
            }else{
                if(r3.isChecked()){
                    int resultado = v1 * v2;
                    tv1.setText("EL RESULTADO ES: "+resultado);
                }else {
                    float resultado = v1 / v2;
                    tv1.setText("EL RESULTADO ES: "+resultado);
                }
            }
        }


    }
}