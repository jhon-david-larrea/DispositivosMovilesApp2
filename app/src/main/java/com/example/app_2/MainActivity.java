package com.example.app_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etCedula, etEdad, etCelular, etCorreo;
    Button btnContinuar;

    String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Estoy en el onCreate");

        etNombre = findViewById(R.id.etNombre);
        etCedula = findViewById(R.id.etCedula);
        etEdad = findViewById(R.id.etEdad);
        etCelular = findViewById(R.id.etCelular);
        etCorreo = findViewById(R.id.etCorreo);
        btnContinuar = findViewById(R.id.btnContinuar);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos de los EditText
                String nombre = etNombre.getText().toString();
                String cedula = etCedula.getText().toString();
                String edad = etEdad.getText().toString();
                String celular = etCelular.getText().toString();
                String correo = etCorreo.getText().toString();

                // Verificar que los campos no estén vacíos
                if (nombre.isEmpty() || cedula.isEmpty() || edad.isEmpty() ||
                        celular.isEmpty() || correo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    // Crear un Intent para ir a MainActivity2
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    // Pasar los datos a través del Intent
                    intent.putExtra("Nombre", nombre);
                    intent.putExtra("Cedula", cedula);
                    intent.putExtra("Edad", edad);
                    intent.putExtra("Celular", celular);
                    intent.putExtra("Correo", correo);

                    // Iniciar MainActivity2
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Estoy en el onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Estoy en el onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Estoy en el onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Estoy en el onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Estoy en el onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Estoy en el onDestroy");
    }
}