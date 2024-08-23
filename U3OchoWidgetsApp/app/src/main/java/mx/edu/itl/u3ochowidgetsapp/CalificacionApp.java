/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*             Activity que Despliega un menu donde puede calificar la app
:*
:*  Archivo     : CalificacionApp.java
:*  Autor       : Emiliano Cepeda Villarreal 20130792
:*  Fecha       : 30/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripción : Esta app despliega en pantalla el un menu donde el usuario califica la app con estrellas.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.u3ochowidgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class CalificacionApp extends AppCompatActivity {

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calificacion_app);

        ratingBar = findViewById ( R.id.rbarCalificacion );
    }

    public void btnEnviarClick ( View v ) {
        float valRatinBar = ratingBar.getRating();
        Toast.makeText ( this, "Su calificacion fue de: " + valRatinBar
                + " ,Gracias por su Opinion!" , Toast.LENGTH_SHORT ).show();
        Intent intent = new Intent (
                CalificacionApp.this,
                PerfilUsuario.class
        );
        startActivity ( intent );
        finish();
    }
}