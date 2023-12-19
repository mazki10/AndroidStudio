    
    //poner un radio buttom activo por defecto
    <RadioButton
     android:id="@+id/radioButton1"
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:text="Opción 1"
     android:checked="true"/> <!-- Este botón estará marcado por defecto -->


    //verificacion de radio buttoms
    int selectedRadioButtonId = gru.getCheckedRadioButtonId();
    selectedRadioButtonId == -1 //para comprobar si no se a pulsado ningun radio buttom
    gru.clearCheck(); //para limpiar todos los radio buttoms de un radio group


    //recojer en un String el dato un objeto
    String dato =  texto.getText().toString()


    //verificar campo vacio
    String dato = tDato.getText().toString();//haber pasado a String el dato

    TextUtils.isEmpty(dato)


    //evento on click
    boton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //logica del programa
    }
    });


    //metodo para terminar una actividad
    finish();


    //lanzar nuevas actividades
    public void lanzarNuevaActividad(View v) {
        String nombre = tNom.getText().toString();

        Intent intent = new Intent(this, Actividad_Secundaria.class);//declarar la nueva actividad

        intent.putExtra("Nombre", dato);//pasar datos a la actividad

        startActivity(intent);//lanzar la actividad

        datoRecojido = intent.getStringExtra("Nombre");//recojer datos
    }


    //dialogo
    public void dialogo(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Titulo")
                .setMessage("mensaje")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //logica del programa
                    }
                })
                .setNegativeButtom("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //logica del programa
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    //toast
    Toast.makeText(this, "mensaje", Toast.LENGTH_SHORT).show();


    //diferentes conversiones ----> se puede meter la conversion a texto del elemento (String dato = tDato.getText().toString();)
    int int = Integer.parseInt(loQueSea); //a tipo int
    Double double = Double.parseDouble(loQueSea); //a tipo double
    String string = String.valueOf(loQueSea); //a tipo String




