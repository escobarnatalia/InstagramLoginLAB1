package co.natalia.instagramlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ConfirmsActivity extends AppCompatActivity {

    private Button siBtn, noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirms);

        //String username = getIntent().getExtras().getString("username"); extra que recibe el dato y lo nombra con el tipo de dato

        siBtn = findViewById(R.id.siBtn);
        noBtn = findViewById(R.id.noBtn);

        noBtn.setOnClickListener(
                (v) ->{
                    finish();
                }
        );

        siBtn.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, UsernameEditActivity.class);
                    startActivity(i);
                    finish();
                    //i.putExtra("username", username); extra que recibe e identifica el dato
                }
        );

    }
}