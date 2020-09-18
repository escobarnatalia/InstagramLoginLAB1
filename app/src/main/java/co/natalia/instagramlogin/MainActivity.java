package co.natalia.instagramlogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView loginLogo;
    private EditText loginUsername;
    private EditText loginPassword;
    private Button loginSiginBtn;
    private TextView loginTextdetails;
    private TextView loginGethelp;
    private TextView loginWithface;
    private ImageView loginImageFace;
    private Button loginSignupBtn;
    private TextView loginTitleCont;
    private Button control;
    private int contador;
    private boolean buttonPressed = false;


    //primer metodo que se ejecuta en una actividad
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar
        loginLogo = findViewById(R.id.loginLogo);
        loginUsername = findViewById(R.id.loginUsername);
        loginPassword = findViewById(R.id.loginPassword);
        loginSiginBtn = findViewById(R.id.loginSiginBtn);
        loginTextdetails = findViewById(R.id.loginTextdetails);
        loginGethelp = findViewById(R.id.loginGethelp);
        loginWithface = findViewById(R.id.loginWithface);
        loginImageFace = findViewById(R.id.loginImageFace);
        loginSignupBtn = findViewById(R.id.loginSignupBtn);
        loginTitleCont = findViewById(R.id.loginTitleCont);
        control = findViewById(R.id.control);

        //se implemento la interfaz OnClick
        loginSiginBtn.setOnClickListener(this);

        loginLogo.setOnTouchListener(
                (view, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            loginTextdetails.setText("DOWN: " + event.getX() + ";" + event.getY());
                            break;
                        case MotionEvent.ACTION_MOVE:
                            loginTextdetails.setText("MOVE " + event.getX() + ";" + event.getY());
                            break;
                        case MotionEvent.ACTION_UP:
                            loginTextdetails.setText("UP " + event.getX() + ";" + event.getY());
                            break;

                    }
                    return true;
                }
        );

        control.setOnTouchListener(
                (view, event) -> {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            //cambiar color del boton cuando se ejecuta accion
                            control.setBackgroundColor(Color.rgb(30, 30, 30));
                            buttonPressed = true;
                            new Thread(
                                    () -> {
                                        while (buttonPressed) {
                                            contador++;
                                            Log.e("cuenta", "contador:" + contador++);

                                            //solo el hilo principal(UI Thread) puede ejecutar metodos con resultado grafico
                                            runOnUiThread(() -> loginTitleCont.setText("" + contador));

                                            try {
                                                Thread.sleep(300);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                            ).start();
                            break;
                        case MotionEvent.ACTION_UP:
                            buttonPressed = false;
                            control.setBackgroundColor(Color.rgb(120, 120, 120));
                            break;

                    }
                    return true;
                }
        );

        //forma de llamar la interfaz normal
        /*loginUsername.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //codigo de la accion del boton
                    }
                }
        );*/


        //forma de llamar la interfaz normal
        /*loginLogo.setOnTouchListener(
                new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        //accion del mouse, pressed, dragged, release
                        return false;
                    }
                }
        );*/


        //un evento por toque
        /*control.setOnClickListener(
                (v) -> {
                    contador++;
                    loginTitleCont.setText(""+contador);
                }
        );*/


    }

    @Override
    public void onClick(View view) {
        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();
        //Toast.makeText(this, username + " " + password, Toast.LENGTH_LONG).show();

        SharedPreferences preferences = getSharedPreferences("ejemplo", MODE_PRIVATE);
        preferences.edit().putString("username", username).apply();

        Intent i = new Intent(this, ConfirmsActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.animacionintententrada, R.anim.animacionintentsalida);

        //i.putExtra("username", username); recibo el dato que me estan mandando va antes del starActivity

        //startActivityForResult(i, 10); verificar resultado



        //contro + o
    /* verificar que el username que cambie en la actividad B aparezca en la A
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 10 && resultCode == RESULT_OK) {
            String usernameEdit = data.getExtras().getString("usernameEdit");
            loginUsername.setText(usernameEdit);
        }
    }*/
    }
}