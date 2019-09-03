package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button btnCategoria, btnFabricante, btnProdutos, btnCat, btnFab, btnProd, btnVendas,
            btnVisualizaVendas, btnUsuarioVendas, btnSairVendas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Todos os botões
        btnCategoria = findViewById(R.id.btnCategoria);
        btnCat = findViewById(R.id.btnCat);
        btnFab = findViewById(R.id.btnFab);
        btnFabricante = findViewById(R.id.btnFabricante);
        btnProdutos = findViewById(R.id.btnProdutos);
        btnProd = findViewById(R.id.btnProd);
        btnVendas = findViewById(R.id.btnVendas);
        btnVisualizaVendas = findViewById(R.id.btnVisualizaVendas);
        btnUsuarioVendas = findViewById(R.id.btnUsuarioVendas);
        btnSairVendas = findViewById(R.id.btnSairVendas);
        //endregion

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Categoria.class);
                startActivity(intent);
            }
        });
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, viewCategoria.class);
                startActivity(intent);
            }
        });
        btnSairVendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, login.class);
                startActivity(intent);
            }
        });

    }
}
