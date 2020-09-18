package co.natalia.instagramlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UsernameEditActivity extends AppCompatActivity {

    private Button cerrarBtn;
    private EditText usernameEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username_edit);

        //llamo el objeto y lo tarigo a esta actividad
        //String username = getIntent().getExtras().getString("username");

        cerrarBtn = findViewById(R.id.cerrarBtn);
        usernameEdit = findViewById(R.id.usernameEdit);

        SharedPreferences preference = getSharedPreferences("ejemplo", MODE_PRIVATE);
        String username = preference.getString("username", "NO_USER");

        //usernameEdit.setText(username);
        usernameEdit.setText(username);

        cerrarBtn.setOnClickListener(

                (v) ->{
                    cerrarActividad();
                    /*Intent i = new Intent();
                    i.putExtra("usernameEdit", usernameEdit.getText().toString());
                    setResult(RESULT_OK, i);

                    //cerrar la actividad
                    finish();
                    //animar la cerrada con las animaciones antes creadas
                    overridePendingTransition(R.anim.animacionintententrada, R.anim.animacionintentsalida);*/
                }
        );
    }

    //este metodo es para que la accion se guarde si le doy en el boton que seleccione o si le doy atras
    @Override
    public void onBackPressed() {

        cerrarActividad();
    }
    //metodo que cree para meter la orden de guardar los datos
    public void cerrarActividad (){
        Intent i = new Intent();
        //i.putExtra("usernameEdit", usernameEdit.getText().toString());
        setResult(RESULT_OK, i);
        finish();
        overridePendingTransition(R.anim.animacionintententrada, R.anim.animacionintentsalida);

    }

}