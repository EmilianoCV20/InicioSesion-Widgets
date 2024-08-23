/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*             Activity que Despliega el Menú de Inicio de sesion de la App
:*
:*  Archivo     : InicioDeSesion.java
:*  Autor       : Emiliano Cepeda Villarreal 20130792
:*  Fecha       : 30/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripción : Esta app despliega en pantalla el menú de un inicio de sesion de un usuario.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.u3ochowidgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class InicioDeSesion extends AppCompatActivity {
    private ProgressBar progressBar;
    private TextView edtUsu, edtCargado;
    private EditText edtCon;
    Handler handler = new Handler();
    int progreso = 0;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.inicio_sesion );

        progressBar = findViewById( R.id.progressBar );
        edtUsu = findViewById( R.id.edtUsuario );
        edtCon = findViewById( R.id.edtContrasena );
        edtCargado = findViewById( R.id.edtProgreso );

    }

    public void btnAceptarClick( View v ) {
        String usuario = edtUsu.getText().toString();
        String contrasena = edtCon.getText().toString();

        if( usuario.equals( "usuario" )) {
            if ( contrasena.equals( "contrasena" )) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while ( progreso < 100 ) {
                            progreso = progreso + 10;
                            handler.post( new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress( progreso );
                                    if ( progreso == 100 ) {
                                        Intent intent = new Intent (
                                                InicioDeSesion.this,
                                                PruebaCaptcha.class
                                        );
                                        startActivity ( intent );
                                        finish();
                                    }
                                    edtCargado.setText( progreso + "%" );
                                }
                            });

                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            }else{
                Toast.makeText( InicioDeSesion.this,
                        "Datos Ingresados INCORRECTOS", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText( InicioDeSesion.this,
                    "Datos Ingresados INCORRECTOS", Toast.LENGTH_LONG).show();
        }
    }

    public void btnSalirClick( View v ) {
        finish();
    }
}