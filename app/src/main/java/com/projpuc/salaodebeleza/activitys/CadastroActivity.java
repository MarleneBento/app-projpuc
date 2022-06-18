package com.projpuc.salaodebeleza.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.projpuc.salaodebeleza.R;

public class CadastroActivity extends AppCompatActivity {

    Button button, buttonProximaTela ;
    TextView textView;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        button = findViewById(R.id.buttonTela);
        textView = findViewById(R.id.textView);
        editText =  findViewById(R.id.editTextTextPersonName2);
        buttonProximaTela = findViewById(R.id.buttonProxTela);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = editText.getText().toString();
                //Toast.makeText(CadastroActivity.this, texto , Toast.LENGTH_SHORT).show();
                textView.setText(texto);
            }
        });

        buttonProximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proximaTela = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(proximaTela);
            }
        });

    }


}