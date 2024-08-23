/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2023    HORA: 08-09 HRS
:*
:*             Activity que Despliega el Menú de el Perfil del Usuario de la App
:*
:*  Archivo     : PerfilUsuario.java
:*  Autor       : Emiliano Cepeda Villarreal 20130792
:*  Fecha       : 30/Oct/2023
:*  Compilador  : Android Studio Flamingo 2022.2.1
:*  Descripción : Esta app despliega en pantalla el menú del perfil del usuario con varios widgets.
:*------------------------------------------------------------------------------------------*/
package mx.edu.itl.u3ochowidgetsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class PerfilUsuario extends AppCompatActivity {

    FloatingActionButton fab, fab1, fab2;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    public DatePickerDialog dpd;
    public Button btnDate;
    private AutoCompleteTextView autotxtPaises;
    private String [] arrPaises = { "Mexico", "USA", "Canada", "Brazil", "Argentina",
            "Colombia", "Chile", "Peru", "Costa_Rica", "Guatemala", "Honduras"   };
    boolean isOpen = false;
    Chip chip;
    MaterialButton btnAgregarEtiqueta;
    ChipGroup chipGroup;
    TextInputEditText textEdit;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_perfil_usuario );
        initDatePicker();
        btnDate = findViewById( R.id.btnDatePicker );
        btnDate.setText( getTodaysDate() );

        ArrayAdapter arrayAdapter = new ArrayAdapter ( this,
                android.R.layout.simple_list_item_1,
                arrPaises );

        autotxtPaises = findViewById ( R.id.autotxtPaises );
        autotxtPaises.setThreshold ( 1 );
        autotxtPaises.setAdapter  ( arrayAdapter );

        fab = ( FloatingActionButton ) findViewById( R.id.fabM );
        fab1 = ( FloatingActionButton ) findViewById( R.id.fabEstrella );
        fab2 = ( FloatingActionButton ) findViewById( R.id.fabInfo );

        fabOpen = AnimationUtils.loadAnimation( this,R.anim.fab_open );
        fabClose = AnimationUtils.loadAnimation( this,R.anim.fab_close );

        rotateForward = AnimationUtils.loadAnimation( this,R.anim.rotate_forward );
        rotateBackward = AnimationUtils.loadAnimation( this,R.anim.rotate_backward );

        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                animatefab();
            }
        });
        fab1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                animatefab();
                Intent intent = new Intent (
                        PerfilUsuario.this, CalificacionApp.class );
                startActivity ( intent );
                finish();
            }
        });
        fab2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                animatefab();
                Intent intent = new Intent(
                        PerfilUsuario.this, AcercaDe.class );
                startActivity( intent );
                finish();
            }
        });

        //Chip
        chip = ( Chip )findViewById( R.id.pruebaChip );
        chip.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText( PerfilUsuario.this,"Chip "+isChecked,
                        Toast.LENGTH_SHORT ).show();
            }
        });
        chip.setOnCloseIconClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Toast.makeText( PerfilUsuario.this,"Chip ",
                        Toast.LENGTH_SHORT).show();
            }
        });

        //ChipGroup
        btnAgregarEtiqueta = ( MaterialButton )findViewById( R.id.btnAgregarEtiqueta );
        chipGroup = ( ChipGroup )findViewById( R.id.chip_group );
        textEdit = ( TextInputEditText ) findViewById(R.id.input3 );
        btnAgregarEtiqueta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {

                String[] tags = textEdit.getText().toString().split( " " );
                LayoutInflater inflater = LayoutInflater.from( PerfilUsuario.this );
                for(String text : tags)
                {
                    Chip chip = (Chip)inflater.inflate (
                            R.layout.chip_item, null,false );
                    chip.setText( text );
                    chip.setOnCloseIconClickListener( new View.OnClickListener() {
                        @Override
                        public void onClick( View v ) {
                            chipGroup.removeView( v );
                        }
                    });
                    chipGroup.addView(chip);
                }
            }
        });
    }

    private void animatefab(){
        if ( isOpen ){
            fab.startAnimation( rotateForward );
            fab1.startAnimation( fabClose );
            fab2.startAnimation( fabClose );
            fab1.setClickable( false );
            fab2.setClickable( false );
            isOpen = false;
        } else
        {
            fab.startAnimation( rotateBackward );
            fab1.startAnimation( fabOpen );
            fab2.startAnimation( fabOpen );
            fab1.setClickable( true );
            fab2.setClickable( true) ;
            isOpen = true;
        }
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int ano = cal.get( Calendar.YEAR );
        int mes = cal.get( Calendar.MONTH );
        mes = mes + 1;
        int dia = cal.get( Calendar.DAY_OF_MONTH );
        return makeDateString( dia, mes, ano );
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener
                = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet( DatePicker datePicker, int ano, int mes, int dia )
            {
                mes = mes + 1;
                String fecha = makeDateString( dia, mes, ano );
                btnDate.setText(fecha);
            }
        };

        Calendar cal = Calendar.getInstance();
        int ano = cal.get( Calendar.YEAR );
        int mes = cal.get( Calendar.MONTH );
        int dia = cal.get( Calendar.DAY_OF_MONTH );

        int style = AlertDialog.THEME_HOLO_LIGHT;

        dpd = new DatePickerDialog( this, style, dateSetListener, ano, mes, dia );
    }

    private String makeDateString( int dia, int mes, int ano )
    {
        return getMesFormat( mes ) + " " + dia + " " + ano;

    }

    private String getMesFormat( int mes ) {

        if( mes == 1 )
            return "Ene";
        if( mes == 2 )
            return "Feb";
        if( mes == 3 )
            return "Mar";
        if( mes == 4 )
            return "Abr";
        if( mes == 5 )
            return "May";
        if( mes == 6 )
            return "Jun";
        if( mes == 7 )
            return "Jul";
        if( mes == 8 )
            return "Ago";
        if( mes == 9 )
            return "Sep";
        if( mes == 10 )
            return "Oct";
        if( mes == 11 )
            return "Nov";
        if( mes == 12 )
            return "Dic";
        return "Ene";

    }

    public void AbrirDatePicker(View view)
    {
        dpd.show();
    }

    public void btnSalirClick( View v ) {
        finish();
    }

}