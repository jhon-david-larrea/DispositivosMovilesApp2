package com.example.app_2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
public class MainActivity2 extends AppCompatActivity{

    Button btnCamara;
    ImageView imageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    TextView tvNombre, tvCedula, tvEdad, tvCelular, tvCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);

        // Vincular los TextView con el layout
        tvNombre = findViewById(R.id.tvNombre);
        tvCedula = findViewById(R.id.tvCedula);
        tvEdad = findViewById(R.id.tvEdad);
        tvCelular = findViewById(R.id.tvCelular);
        tvCorreo = findViewById(R.id.tvCorreo);

        // Recibir los datos del Intent
        Intent recibirDatos = getIntent();
        String nombre = recibirDatos.getStringExtra("Nombre");
        String cedula = recibirDatos.getStringExtra("Cedula");
        String edad = recibirDatos.getStringExtra("Edad");
        String celular = recibirDatos.getStringExtra("Celular");
        String correo = recibirDatos.getStringExtra("Correo");

        // Mostrar los datos en los TextView
        tvNombre.setText("Nombre: " + nombre);
        tvCedula.setText("Cédula: " + cedula);
        tvEdad.setText("Edad: " + edad);
        tvCelular.setText("Celular: " + celular);
        tvCorreo.setText("Correo: " + correo);

        // Inicializa los componentes
        btnCamara = findViewById(R.id.btnCamara);
        imageView = findViewById(R.id.ivImagen);

        // Acción del botón para abrir la cámara
        btnCamara.setOnClickListener(view -> dispatchTakePictureIntent());
    }
    // Método para abrir la cámara
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);  // Muestra la imagen en el ImageView
        }
    }


}
