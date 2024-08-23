/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*                 Activity que Despliega los creditos de la app de Widgets
:*
:*  Archivo     : AcercaDe.java
:*  Autor       : Emiliano Cepeda Villarreal 20130792
:*  Fecha       : 30/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripción : Esta app despliega en pantalla de los creditos de la app con widgets.
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.u3ochowidgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.acerca_de );
    }

    public void btnAtras2Click ( View v ) {
        Intent intent = new Intent( AcercaDe.this, PerfilUsuario.class );
        startActivity( intent );
        finish();
    }
}