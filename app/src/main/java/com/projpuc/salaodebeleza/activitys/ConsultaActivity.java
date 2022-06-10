package com.projpuc.salaodebeleza.activitys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.projpuc.salaodebeleza.R;
import com.projpuc.salaodebeleza.adapters.ProdutoAdapter;
import com.projpuc.salaodebeleza.services.ProdutoService;

import java.util.ArrayList;


public class ConsultaActivity extends AppCompatActivity {
    private RecyclerView recyclerViewProdutos;
    private ProdutoAdapter adapter;
    Button buttonBuscar;
    private ProdutoService produtoService = new ProdutoService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);
        adapter = new ProdutoAdapter(this, recyclerViewProdutos, new ArrayList<>());

        buttonBuscar = findViewById(R.id.buttonConsultarProduto);
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                produtoService.buscarProdutos()
                        .subscribe(produtos -> {
                            adapter.updateData(produtos);
                        }, erro -> {
                            Log.e("CEPService   ", "Erro ao buscar o cep:" + erro.getMessage());
                        });
            }
        });

    }
}