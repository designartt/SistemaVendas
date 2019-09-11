package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button btnCategoria, btnFabricante, btnProdutos, btnViewCategoria, btnVisFab, btnVisProd, btnVendas,
            btnVisVendas, btnUsuario, btnSairVendas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region Todos os botões
        btnCategoria = findViewById(R.id.btnCategoria);
        btnViewCategoria = findViewById(R.id.btnVisCat);
        btnFabricante = findViewById(R.id.btnFabricante);
        btnVisFab = findViewById(R.id.btnVisFab);
        btnProdutos = findViewById(R.id.btnProdutos);
        btnVisProd = findViewById(R.id.btnVisProd);
        btnVendas = findViewById(R.id.btnVendas);
        btnVisVendas = findViewById(R.id.btnVisVendas);
        btnUsuario = findViewById(R.id.btnUsuario);
        btnSairVendas = findViewById(R.id.btnSairVendas);
        //endregion

        btnCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Categoria.class);
                startActivity(intent);
            }
        });
        btnViewCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, viewCategoria.class);
                startActivity(intent);
            }
        });

        btnFabricante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Fabricante.class);
                startActivity(intent);
            }
        });

        btnVisFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, viewFabricante.class);
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
