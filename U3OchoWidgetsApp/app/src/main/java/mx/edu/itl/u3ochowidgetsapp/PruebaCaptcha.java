/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                    Activity que Despliega una prueba Captcha
:*
:*  Archivo     : PruebaCaptcha.java
:*  Autor       : Emiliano Cepeda Villarreal 20130792
:*  Fecha       : 30/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripción : Esta app despliega en pantalla una prueba captcha para iniciar sesion.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.u3ochowidgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class PruebaCaptcha extends AppCompatActivity {

    private RadioButton Respuesta1, Respuesta2, Respuesta3;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.prueba_captcha );

        Respuesta1 = findViewById ( R.id.rbtnRes1);
        Respuesta2 = findViewById ( R.id.rbtnRes2);
        Respuesta3 = findViewById ( R.id.rbtnRes3);

    }

    public void btnEnviarClick ( View v ) {
        if ( Respuesta1.isChecked() ) {
            Snackbar.make ( v, "RESPUESTA INCORRECTA", Snackbar.LENGTH_LONG ).show();
            Intent intent = new Intent ( PruebaCaptcha.this, InicioDeSesion.class );
            startActivity ( intent );
            finish();
        }
        else if ( Respuesta2.isChecked() ) {
            Snackbar.make ( v, "BIENVENIDO USUARIO", Snackbar.LENGTH_LONG ).show();
            Intent intent = new Intent ( PruebaCaptcha.this, PerfilUsuario.class );
            startActivity ( intent );
            finish();
        }
        else if ( Respuesta3.isChecked() ) {
            Snackbar.make ( v, "RESPUESTA INCORRECTA", Snackbar.LENGTH_LONG ).show();
            Intent intent = new Intent ( PruebaCaptcha.this, InicioDeSesion.class );
            startActivity ( intent );
            finish();
        }
    }
}