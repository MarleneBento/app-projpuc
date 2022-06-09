package com.example.appsalaodebeleza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.appsalaodebeleza.activity.LoginActivity;
import com.example.appsalaodebeleza.activity.NewLoginActivity;

public class BoasVindasActivity extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate()
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
        button = findViewById(R.id.buttonActivityLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teste = new Intent(getApplicationContext(), NewLoginActivity.class);
                startActivity(teste);
            }
        });
    }
}