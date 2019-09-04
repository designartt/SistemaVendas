package com.example.sistemadevendas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditarCategoria extends AppCompatActivity {

    EditText edtCatId, edtCategoria, edtDescricao;
    Button btnCatEditar, btnCatDeletar, btnCatCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editarcategoria);

//        Setando os ids dos EditText
        edtCatId = findViewById(R.id.edtCatId);
        edtCategoria = findViewById(R.id.edtCategoria);
        edtDescricao = findViewById(R.id.edtDescricao);

//        Setando os ids do Button
        btnCatEditar = findViewById(R.id.btnCatEditar);
        btnCatCancelar = findViewById(R.id.btnCatCancelar);
        btnCatDeletar = findViewById(R.id.btnCatDeletar);

        Intent in = getIntent();

        String id = in.getStringExtra("id").toString();
        String categoria = in.getStringExtra("categoria").toString();
        String descricao = in.getStringExtra("descricao").toString();


        edtCatId.setText(id);
        edtCategoria.setText(categoria);
        edtDescricao.setText(descricao);

    }
}
